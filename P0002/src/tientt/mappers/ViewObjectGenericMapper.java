/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.mappers;

import java.util.List;

/**
 *
 * @author natton
 * @param <S>
 * @param <D>
 */
public interface ViewObjectGenericMapper<S, D> {

    D toViewObject(S dto);

    S toDTO(D viewObject);

    List<D> toListViewObject(List<S> listDTO);

    List<S> toListDTO(List<D> listViewObject);
}
