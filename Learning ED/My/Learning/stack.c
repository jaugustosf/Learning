#include <stdio.h>
#include <stdlib.h>

typedef struct no{
    int value;
    struct no *prox;
}NO;

NO *top = NULL;

void push(int value){
    NO *new = malloc(sizeof(NO));

    new -> value = value;
    new -> prox = top;
    top = new;
}

int pop(){
    if(top == NULL){
        printf("A pilha esta vazia.\n");
        return 0;
    }else{
        NO *aux = top;
        int value = top -> value;
        top = top -> prox;
        free(aux);
        return value;
    }
}

void see(){
    if(top == NULL){
        printf("A pilha esta vazia.\n");
    }else{
        NO *aux = top;
        while(aux != NULL){
            printf("%d\n",aux->value);
            aux = aux -> prox;
        }
    }
}

int main(){
    push(1);
    push(2);
    push(3);
    push(4);
    see();
}