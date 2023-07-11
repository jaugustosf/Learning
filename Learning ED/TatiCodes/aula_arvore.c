#include<stdio.h>
#include<stdlib.h>

typedef struct no{
    int chave;
    //dados dependem da aplicacao
    struct no * dir;
    struct no * esq;
}NO;


NO *raiz = NULL;

NO * busca_arvore(int x, NO *pt){
    if(pt == NULL){ //arv. vazia
        return NULL;
    }else if(x == pt->chave){ //encontrado
        return pt;
    }else if(x < pt->chave){
        //esq! :D
        if(pt->esq == NULL){
            return pt;
        }else{
            return busca_arvore(x, pt->esq);
        }
    }else{
        //dir
        if(pt->dir == NULL){
            return pt;
        }else{
            return busca_arvore(x, pt->dir);
        }
    }
}

void insercao_arvore(int x){
    NO * pt = busca_arvore(x, raiz);
    if(pt != NULL){ //arvore nao ta vazia
        if(pt->chave == x){
            printf("Chave duplicada!\n");
        }else{
            NO *pt1 = malloc(sizeof(NO));
            pt1->chave = x;
            pt1->esq = NULL;
            pt1->dir = NULL;
            if(x <pt->chave){
                pt->esq = pt1;
            }else{
                pt->dir = pt1;
            }
        }
    }else{//arvore vazia
        NO *pt1 = malloc(sizeof(NO));
        pt1->chave = x;
        pt1->esq = NULL;
        pt1->dir = NULL;
        raiz = pt1;
        
    }
}

void pre(NO *pt){
    
    printf("%d ", pt->chave);
    if(pt->esq != NULL){
        pre(pt->esq);
    }
    if(pt->dir != NULL){
        pre(pt->dir);
    }
}



int main(){
    insercao_arvore(30);
    insercao_arvore(20);
    insercao_arvore(40);
    insercao_arvore(10);
    insercao_arvore(25);
    insercao_arvore(5);
    insercao_arvore(15);
    insercao_arvore(22);
    insercao_arvore(35);
    insercao_arvore(50);
    insercao_arvore(45);
    insercao_arvore(60);
    pre(raiz);
    
    return 0;
}


