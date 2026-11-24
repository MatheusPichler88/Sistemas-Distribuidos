import streamlit as st
import Pyro5.api
import base64

st.set_page_config(page_title="Encurtador RPC")


def servidor():
    return Pyro5.api.Proxy("PYRONAME:encurtador")


if "token" not in st.session_state:
    st.session_state.token = None
    st.session_state.usuario = None

st.title("Encurtador de Links")

if st.session_state.token is None:
    st.subheader("Login")
    usuario = st.text_input("Usuário")
    senha = st.text_input("Senha", type="password")

    if st.button("Entrar"):
        try:
            token = servidor().login(usuario, senha)
        except Exception as e:
            st.error(f"Não foi possível conectar ao servidor: {e}")
        else:
            if token is None:
                st.error("Usuário ou senha inválidos")
            else:
                st.session_state.token = token
                st.session_state.usuario = usuario
                st.rerun()

else:
    st.write(f"Logado como **{st.session_state.usuario}**")
    if st.button("Sair"):
        st.session_state.token = None
        st.rerun()

    st.subheader("Encurtar link")
    url = st.text_input("Cole o link:", placeholder="https://...")

    if st.button("Encurtar"):
        if not url:
            st.warning("Digite um link")
        else:
            try:
                link = servidor().encurtar_link(st.session_state.token, url)
            except Exception as e:
                st.error(f"Não foi possível conectar ao servidor: {e}")
            else:
                if link is None:
                    st.error("Sessão inválida, clique em Sair e faça login de novo")
                else:
                    st.success("Link encurtado!")
                    st.code(link)

                    try:
                        qr = servidor().gerar_qrcode(st.session_state.token, link)
                    except Exception as e:
                        st.error(f"Não foi possível gerar o QR Code: {e}")
                    else:
                        if qr is not None:
                            imagem = base64.b64decode(qr)
                            st.image(imagem, caption="QR Code do link encurtado", width=250)
                            st.download_button(
                                "Baixar QR Code",
                                imagem,
                                file_name=f"qrcode_{link.split('/')[-1]}.png",
                                mime="image/png",
                            )
