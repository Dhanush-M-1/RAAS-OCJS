#include<stdio.h>
int main(){
  int n,A[100],mini,cnt=0,x;
  int i,j;
  scanf("%d",&n);
  for(i=0;i<n;i++){
    scanf("%d",&A[i]);
  }
  for(i=0;i<n;i++){
    mini = i;
    for(j=i;j<n;j++){
      if(A[j] < A[mini]){
        mini = j;
      }
    }
    if(mini!=i){
      x = A[i];
      A[i] = A[mini];
      A[mini] = x;
      cnt++;
    }
  }
  for(i=0;i<n-1;i++){
    printf("%d ",A[i]);
  }
  printf("%d\n%d\n",A[n-1],cnt);
}