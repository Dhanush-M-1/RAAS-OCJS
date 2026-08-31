#include<stdio.h>
int main(){
  int n,k;
  int i,j;
  int count;
  while(scanf("%d",&n)){
    if(n==0) break;
    int index[n];
    count = 0;
    for(i=0;i<n;i++) scanf("%d",&index[i]);
    for(i=n-1;i>0;i--){
      for(j=0;j<i;j++){
	if(index[j]>index[j+1]){
	  k = index[j];
	  index[j] = index[j+1];
	  index[j+1] = k;
	  count++;
	}
      }
    }
    printf("%d\n",count);
  }
  return 0;
}