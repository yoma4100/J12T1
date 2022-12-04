package ru.netology.domain;

import ru.netology.Product;
import ru.netology.repository.Repository;

public class Manager {
    private Repository repo;

    public Manager(Repository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.save(product);
    }

    public void removeById(int id) {
        repo.removeById(id);
    }

    public Product[] searchBy(String text) {
        int size = 0;
        for (Product product : repo.findAll()) {
            if (product.getName().equals(text)) {
                size++;
            }
        }

        Product[] result = new Product[0];
        Product[] tmp = new Product[size];
        int copyToIndex = 0;

        for (Product product : repo.findAll()) {
            if (product.getName().equals(text)) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }

        if (size != 0) {
            result = tmp;
        }
        return result;
    }
}
