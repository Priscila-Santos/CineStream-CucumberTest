package br.ada.cinestream_test.dto.mapping;

import br.ada.cinestream_test.dto.request.SerieFavoritaRequest;
import br.ada.cinestream_test.model.Usuario;
import br.ada.cinestream_test.model.SerieFavorita;

public class SerieFavoritaMapper {

    public SerieFavorita toEntity(SerieFavoritaRequest dto, Usuario usuario) {
        SerieFavorita serieFavorita = new SerieFavorita();
        serieFavorita.setTmdbId(dto.getIdSerie());
        serieFavorita.setUsuario(usuario);
        return serieFavorita;
    }
}
