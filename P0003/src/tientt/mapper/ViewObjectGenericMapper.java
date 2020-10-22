/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.mapper;

import java.util.List;

/**
 *
 * @author natton
 */
public interface ViewObjectGenericMapper<S, D> {
    S toDTO(D viewObject);
    D toViewObject(S dto);
    List<S> toListDTOs(List<D> listViewObjects);
    List<D> toListViewObjects(List<S> listDTOs);
}
