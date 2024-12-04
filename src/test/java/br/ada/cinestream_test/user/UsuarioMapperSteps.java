package br.ada.cinestream_test.user;

import br.ada.cinestream_test.dto.mapping.UsuarioMapper;
import br.ada.cinestream_test.dto.request.UsuarioRequest;
import br.ada.cinestream_test.dto.response.UsuarioResponse;
import br.ada.cinestream_test.model.Usuario;
import br.ada.cinestream_test.tmdb.response.TmdbFilme;
import br.ada.cinestream_test.tmdb.response.TmdbSerie;
import io.cucumber.java.pt.*;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioMapperSteps {

    private UsuarioMapper usuarioMapper;
    private UsuarioRequest usuarioRequest;
    private Usuario usuario;
    private UsuarioResponse usuarioResponse;
    private List<TmdbFilme> filmesFavoritos;
    private List<TmdbSerie> seriesFavoritas;

    @Dado("um UsuarioRequest com nome {string}, nickname {string} e email {string}")
    public void umUsuarioRequest(String nome, String nickname, String email) {
        usuarioMapper = new UsuarioMapper();
        usuarioRequest = new UsuarioRequest();
        usuarioRequest.setNome(nome);
        usuarioRequest.setNickname(nickname);
        usuarioRequest.setEmail(email);
    }

    @Quando("eu converter para Usuario")
    public void euConverterParaUsuario() {
        usuario = usuarioMapper.toEntity(usuarioRequest);
    }

    @Entao("o nome deve ser {string}")
    public void oNomeDeveSer(String nome) {
        assertEquals(nome, usuario.getNome());
    }

    @Entao("o nickname deve ser {string}")
    public void oNicknameDeveSer(String nickname) {
        assertEquals(nickname, usuario.getNickName());
    }

    @Entao("o email deve ser {string}")
    public void oEmailDeveSer(String email) {
        assertEquals(email, usuario.getEmail());
    }

    @Dado("um Usuario com id {long}, nome {string}, nickname {string} e email {string}")
    public void umUsuario(Long id, String nome, String nickname, String email) {
        usuarioMapper = new UsuarioMapper();
        usuario = new Usuario();
        usuario.setId(id);
        usuario.setNome(nome);
        usuario.setNickName(nickname);
        usuario.setEmail(email);
    }

    @Dado("uma lista de filmes favoritos")
    public void umaListaDeFilmesFavoritos() {
        TmdbFilme filme = new TmdbFilme("Inception", "A mind-bending thriller", "2010-07-16", 8.8, "/posterPath.jpg", 100L);
        filmesFavoritos = Collections.singletonList(filme);
    }

    @Dado("uma lista de series favoritas")
    public void umaListaDeSeriesFavoritas() {
        TmdbSerie serie = new TmdbSerie(Collections.singletonList(18), 200, "Breaking Bad", "A high school chemistry teacher turned methamphetamine producer", "2008-01-20", 9.5, 1256, "/posterPath.jpg");
        seriesFavoritas = Collections.singletonList(serie);
    }

    @Quando("eu converter para UsuarioResponse")
    public void euConverterParaUsuarioResponse() {
        usuarioResponse = usuarioMapper.toDTO(usuario, filmesFavoritos, seriesFavoritas);
    }

    @Entao("o id deve ser {long}")
    public void oIdDeveSer(Long id) {
        assertEquals(id, usuarioResponse.getId());
    }

    @Entao("a lista de filmes favoritos deve ter {int} filme")
    public void aListaDeFilmesFavoritosDeveTer(int size) {
        assertEquals(size, usuarioResponse.getFilmesFavoritos().size());
    }

    @Entao("a lista de series favoritas deve ter {int} serie")
    public void aListaDeSeriesFavoritasDeveTer(int size) {
        assertEquals(size, usuarioResponse.getSeriesFavoritas().size());
    }
}

