package br.ada.cinestream_test.dto.mapping;

import br.ada.cinestream_test.dto.request.FilmeFavoritoRequest;
import br.ada.cinestream_test.model.Usuario;
import br.ada.cinestream_test.model.FilmeFavorito;

public class FilmeFavoritoMapper {

    public FilmeFavorito toEntity(FilmeFavoritoRequest dto, Usuario usuario) {
        FilmeFavorito filmeFavorito = new FilmeFavorito();
        filmeFavorito.setTmdbId(dto.getIdFilme());
        filmeFavorito.setUsuario(usuario);
        return filmeFavorito;
    }
}
