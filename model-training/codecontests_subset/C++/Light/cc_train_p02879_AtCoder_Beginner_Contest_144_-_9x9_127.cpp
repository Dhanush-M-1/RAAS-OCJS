#include <bits/stdc++.h>
int a,b;
int main(){
	scanf("%d%d",&a,&b);
	if(a>=1 && a<=9 && b>=1 && b<=9){
		printf("%d\n",a*b);
	} else puts("-1");
}