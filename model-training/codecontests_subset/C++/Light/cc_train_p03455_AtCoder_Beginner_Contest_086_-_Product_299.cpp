# include <stdio.h>
	 int main(){
  	int a, b;
  	scanf("%d %d", &a, &b);
  	puts(a*b&1 ? "Odd" : "Even");
  	return 0;
		}