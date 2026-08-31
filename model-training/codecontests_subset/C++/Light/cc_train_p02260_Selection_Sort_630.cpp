#include<stdio.h>
int main(){

  int a,i,minj,A[100],c,count,j;
  scanf("%d",&a);
  for(i=0;i<a;i++)scanf("%d",&A[i]);
  
  for (i=0;i<a;i++){
    minj = i;
    for (j=i;j<=a-1;j++){
      if (A[j] < A[minj]){
        minj = j;
      }
    }
    if(minj!=i){
	c=A[i];
	A[i]=A[minj];
	A[minj]=c;
	count++;
    }
    
  }
  for(i=0;i<a;i++){
    if(i!=a-1)printf("%d ",A[i]);
    else printf("%d\n%d\n",A[i],count);
  }

}

