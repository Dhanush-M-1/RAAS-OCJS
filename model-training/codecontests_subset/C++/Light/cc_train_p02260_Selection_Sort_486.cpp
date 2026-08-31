#include<stdio.h>
int selectionSort(int A[],int N)
{
    int i,j,t,sum=0,minj;
    for(i=0;i<N-1;i++){
    minj=i;
    for(int j=i;j<N;j++){
    if(A[j]<A[minj]) minj=j;
    }
    t=A[i];A[i]=A[minj];A[minj]=t;
    if(i!=minj) sum++;
    }
    return sum;
    }
int main(){
int A[100],N,sum,i;
scanf("%d",&N);
for(i=0;i<N;i++) scanf("%d",&A[i]);
sum=selectionSort(A,N);
for(int i=0;i<N;i++){
if(i>0)  printf(" ");
printf("%d",A[i]);
}
printf("\n");
printf("%d\n",sum);
return 0;
}