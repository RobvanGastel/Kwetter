package com.robvangastel.kwetter.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Rob on 23-3-2017.
 */

@Named(value = "IndexBean")
@RequestScoped
public class IndexBean implements Serializable {
}