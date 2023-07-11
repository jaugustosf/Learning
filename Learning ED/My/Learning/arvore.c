#include <stdio.h>
#include <stdlib.h>

typedef struct no{
    int key;
    struct no *right;
    struct no *left;
}NO;

NO *raiz = NULL;

NO *search(int x, NO *aux){
    if(aux == NULL){
        return NULL;
    }else if(x == aux -> key){
        return aux;
    }else if(x < aux -> key){
        if(aux -> left == NULL){
            return aux;
        }else{
            return search(x, aux-> left);
        }
    }else{
        if(aux -> right == NULL){
            return aux;
        }else{
            return search(x, aux-> right);
        }
    }
}

void insert(int x){
    NO * aux = search(x, raiz);
    if(aux != NULL){
        if(aux -> key == x){
            printf("Valor ja existente.");
        }else{
            NO *new = malloc(sizeof(NO));
            new -> key = x;
            new -> left = NULL;
            new -> right = NULL;

            if(x < aux -> key){
                aux -> left = new;
            }else{
                aux -> right = new;
            }
        }
    }else{
        NO *new = malloc(sizeof(NO));
        new -> key = x;
        new -> left = NULL;
        new -> right = NULL;
        raiz = new;
    }
}

void see(NO *aux){
    printf("%d ", aux -> key);
    if(aux -> left != NULL){
        see(aux -> left);
    }


}




int main(){
    insert(30);
    insert(20);
    insert(40);
    insert(10);
    insert(25);
    insert(5);
    insert(15);
    insert(22);
    insert(35);
    insert(50);
    insert(45);
    insert(60);
    see(raiz);
    return 0;
}