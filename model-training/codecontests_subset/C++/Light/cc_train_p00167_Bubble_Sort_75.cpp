#include <stdio.h>

int main(void) {

  int n;
  int a[100];

  int step;

  int temp;
  int i,j;

  while(1) {

    scanf("%d",&n);

    if(n==0) break;

    step=0;

    for(i=0;i<n;i++) {

      scanf("%d",&a[i]);

    }

    for(i=0;i<n-1;i++) {

      for(j=0;j<n-i-1;j++) {

	if(a[j]>a[j+1]) {

	  temp=a[j];
	  a[j]=a[j+1];
	  a[j+1]=temp;

	  step++;

	}

      }

    }

    printf("%d\n",step);

  }

  return 0;

}