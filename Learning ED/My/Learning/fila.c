#include <stdio.h>
#include <stdlib.h>

typedef struct no{
    int value;
    struct no *prox;
}NO;
//Primeiro que entra primeiro a sair.
//Ultimo a entrar ultimo a sair.
typedef struct queue{
    NO *first;
    NO *last;
}queue;

NO *first = NULL;
NO *last = NULL;

void add(int value){
    NO *new = malloc(sizeof(NO));
    new -> value = value;
    new -> prox = NULL;

    if(first == NULL){
        first = new;
        last = new;
    }else{
        last -> prox = new;
        last = new;
    }
}

print(){
    NO *aux = first;
    while(aux != NULL){
        printf("%d ", aux -> value);
        aux = aux -> prox;
    }
}

int delet(){
    NO *aux = first;
    int value = first -> value;
    first = first -> prox;
    free(aux);
    return value;
}

int main(){
    add(1);
    add(2);
    add(3);
    add(4);
    delet();
    print();
}