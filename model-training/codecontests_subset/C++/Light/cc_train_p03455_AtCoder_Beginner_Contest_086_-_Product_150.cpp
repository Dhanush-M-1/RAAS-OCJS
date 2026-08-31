#include<bits/stdc++.h>
int main()
{
	long long a , b;
	scanf("%lld%lld",&a,&b);
	a *= b;
	printf(a % 2 == 0 ? "Even" : "Odd");
	return 0;
 } 