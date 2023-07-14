#include<stdio.h>
#include<stdlib.h>
#include<string.h>

typedef struct no{
    int chave;
    char nome[100];
    int idade;
    struct no *dir;
    struct no *esq;
} NO;

NO *raiz = NULL;

NO *busca_arvore(int chave, NO *walk){
    if(walk == NULL){ // árvore vazia
        return NULL;
    }else if(chave == walk->chave){ // encontrado
        return walk;
    }else if(chave < walk->chave){
        // esq! :D
        if(walk->esq == NULL){
            return walk;
        }else{
            return busca_arvore(chave, walk->esq);
        }
    }else{
        // dir
        if(walk->dir == NULL){
            return walk;
        }else{
            return busca_arvore(chave, walk->dir);
        }
    }
}

void insercao_arvore(int chave, char *nome, int idade){
    NO *walk = busca_arvore(chave, raiz);
    if(walk != NULL){ // árvore não está vazia
        if(walk->chave == chave){
            printf("Chave duplicada!\n");
        }else{
            NO *aux = malloc(sizeof(NO));
            aux->chave = chave;
            strcpy(aux->nome, nome);
            aux->idade = idade;
            aux->esq = NULL;
            aux->dir = NULL;
            if(chave < walk->chave){
                walk->esq = aux;
            }else{
                walk->dir = aux;
            }
        }
    }else{ // árvore vazia
        NO *aux = malloc(sizeof(NO));
        aux->chave = chave;
        strcpy(aux->nome, nome);
        aux->idade = idade;
        aux->esq = NULL;
        aux->dir = NULL;
        raiz = aux;
    }
}

void pre(NO *walk){
    static int i = 0;  // Alteração: tornar i uma variável estática

    if(walk != NULL){
        printf("Usuario %d: %d - %s - %d\n",i = i+1, walk->chave, walk->nome, walk->idade);
        
        pre(walk->esq);
        pre(walk->dir);
    }
}



int main(){
    printf("Lista:\n");
    insercao_arvore(8, "joao", 20);
    insercao_arvore(10, "Patrick", 21);
    insercao_arvore(2, "Ysi", 12);
    insercao_arvore(3, "Edinir", 50);
    insercao_arvore(9, "Cleudenia", 50);
    insercao_arvore(12, "Leleu", 50);
    pre(raiz);

    return 0;
}
