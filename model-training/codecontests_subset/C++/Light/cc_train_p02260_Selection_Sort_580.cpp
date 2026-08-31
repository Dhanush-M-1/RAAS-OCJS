#include<stdio.h>

int main(){
  int minj,i,j,a=0,count=0;
  int N,A[100],c=0;
  scanf("%d",&N);
  for(i=0;i<N;i++){
    scanf("%d",&A[i]);
  }
  for(i=0;i<=N-1;i++){
    minj=i;
    for(j=i;j<=N-1;j++){
      if(A[j]<A[minj]){
	minj=j;
	c=1;
      }
    }
    
    a=A[i];
    A[i]=A[minj];
    A[minj]=a;
    if(c==1){
      count++;
      c=0;
    }
    
  }
  for(i=0;i<N-1;i++){
    printf("%d ",A[i]);
}
  printf("%d\n",A[N-1]);
  printf("%d\n",count);
  return 0;
}