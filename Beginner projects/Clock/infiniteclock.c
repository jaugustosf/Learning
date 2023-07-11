#include <stdio.h>
#include <windows.h>

int main(){
    int h,m,s;
    printf("Digite o horario inicial\n");
    scanf("%d%d%d",&h,&m,&s);
    if(h > 24 || m > 60 || s > 60){
        printf("input invalid\n");
        exit(0);
    }
    while(1){//Para ser um looping infinito.
        s++;
        if(s > 59){
            m++;
            s = 0;
        }
        if(m > 59){
            h++;
            m = 0;
        }
        if(h > 23){
            h = 0;
        }
        printf("Clock\n\n");
        printf("%.2d:%.2d:%.2d",h,m,s);
        Sleep(10);
        system("cls");
    }
}