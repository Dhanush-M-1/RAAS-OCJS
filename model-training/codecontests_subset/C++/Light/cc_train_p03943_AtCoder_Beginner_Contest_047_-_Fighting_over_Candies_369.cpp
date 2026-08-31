#include<stdio.h>
#include<algorithm>
using namespace std;
int main(){
	int a,b,c;
	scanf("%d%d%d",&a,&b,&c);
	if(max(a,(max(b,c)))*2==a+b+c)printf("Yes\n");
	else printf("No\n");
}