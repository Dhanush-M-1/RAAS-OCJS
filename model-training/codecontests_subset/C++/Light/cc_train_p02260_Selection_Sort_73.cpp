#include <stdio.h>
int main(){
  int i,j,min,n,a[100],cnt=0,array;
  scanf("%d",&n);
  for(i=0;i<n;i++)scanf("%d",&a[i]);
  for(i=0;i<n;i++){
    min=i;
    for(j=i;j<n;j++){
      if(a[j]<a[min]){
	min=j;
      }
    }
    if(min!=i){
      cnt++;
      array=a[i];
      a[i]=a[min];
      a[min]=array;
    }
  }
  for(i=0;i<n;i++){
    printf("%d",a[i]);
    if(i!=n-1)printf(" ");
  }
  printf("\n%d\n",cnt);
  return 0;
}

