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

void in(NO *pt){
    if(pt->esq != NULL){
        in(pt->esq);
    }
    printf("%d ", pt->chave);
    if(pt->dir != NULL){
        in(pt->dir);
    }
}

void pos(NO *pt){
    if(pt->esq != NULL){
        pos(pt->esq);
    }
    if(pt->dir != NULL){
        pos(pt->dir);
    }
    printf("%d ", pt->chave);
}

void Ppre(NO *pt){
    // int i = 0;
    if(pt != NULL){
        printf("%d ", pt->chave);
        Ppre(pt->esq);
        Ppre(pt->dir);
    }
}

void Iin(NO *pt){
    //static int i = 0;
    if(pt != NULL){
        
        Iin(pt->esq);
        printf("%d ", pt->chave);
        Iin(pt->dir);
    }
}

void Ppos(NO *pt){
    //static int i = 0;
    if(pt != NULL){
        
        Ppos(pt->esq);
        Ppos(pt->dir);
        printf("%d ", pt->chave);
    }
}

int main(){
    insercao_arvore(6);
    insercao_arvore(9);
    insercao_arvore(7);
    insercao_arvore(3);
    insercao_arvore(4);
    insercao_arvore(5);   

    printf("Em pre-order\n");
    pre(raiz);
    printf("\n");
    Ppre(raiz);
    printf("\n");

    printf("Em In-order\n");
    in(raiz);
    printf("\n");
    Iin(raiz);
    printf("\n");
    
    printf("Em pos-order\n");
    pos(raiz);
    printf("\n");
    Ppos(raiz);
    
    return 0;
}