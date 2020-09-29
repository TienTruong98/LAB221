/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientt.mapper.interfaces;

import java.util.List;

/**
 *
 * @author natton
 */
public interface ViewObjectGenericMapper<S, D> {

    public D toViewObject(S dto);

    public S toDTO(D viewObject);

    public List<D> toListViewObject(List<S> listDTO);

    public List<S> toListDTO(List<D> listViewObject);
}
