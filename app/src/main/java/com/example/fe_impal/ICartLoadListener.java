package com.example.fe_impal;

import com.example.fe_impal.CartModel;
import com.example.fe_impal.KatalogModel;

import java.util.List;

public interface ICartLoadListener {
    void onCartLoadSucces(List<KatalogModel> katalogModelList);
    void onCartLoadFailed(String Message);
}
