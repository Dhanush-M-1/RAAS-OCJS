#include <stdio.h>

int main(){
  int k=0,ba,min,n[105],i,j,a;
  scanf("%d",&a);
  for(i=0;i<a;i++)scanf("%d",&n[i]);
  for(i=0;i<a;i++){
    min=1000000;
    for(j=i;j<a;j++){
      if(min>n[j]){
	min=n[j];
	ba=j;
      }
    }
    if(ba!=i){
      n[ba]=n[i];
      n[i]=min;
      k++;
    }
  }
  for(i=0;i<a-1;i++)printf("%d ",n[i]);
  printf("%d\n",n[a-1]);
  printf("%d\n",k);
  return 0;
}