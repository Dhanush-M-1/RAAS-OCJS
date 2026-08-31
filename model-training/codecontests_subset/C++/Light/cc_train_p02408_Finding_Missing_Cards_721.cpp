#include <stdio.h>
int main(void){
int n,i,j;
scanf("%d",&n);
int a[4][13]={};
for(i=0;i<n;i++){
    char x;
    int y;
    scanf(" %c%d",&x,&y);
    y--;
    if(x=='S')
    a[0][y]++;
    else if(x=='H')
    a[1][y]++;
    else if(x=='C')
    a[2][y]++;
    else
    a[3][y]++;
    
}
for(i=0;i<4;i++){
    char v;
    if(i==0)
    v='S';
    else if(i==1)
    v='H';
    else if(i==2)
    v='C';
    else
    v='D';
    for(j=0;j<13;j++){
        if(a[i][j]==0){
            printf("%c %d\n",v,j+1);
        }
    }
}

return 0;
}