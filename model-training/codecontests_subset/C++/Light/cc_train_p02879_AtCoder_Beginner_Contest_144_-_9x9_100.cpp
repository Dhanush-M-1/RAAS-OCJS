#include<iostream>
using namespace std;
int a,b;
int main()
{
	scanf("%d%d",&a,&b);
	if(a>9||b>9)puts("-1");
	else printf("%d",a*b);
	return 0;
}