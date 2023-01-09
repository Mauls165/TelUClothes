package com.example.fe_impal;

import com.example.fe_impal.KatalogModel;

import java.util.List;

public interface IDKatalogLoadListener {
    void onKatalogLoadSucces(List<KatalogModel> katalogModelList);
    void onKatalogFailed(String Message);
}
