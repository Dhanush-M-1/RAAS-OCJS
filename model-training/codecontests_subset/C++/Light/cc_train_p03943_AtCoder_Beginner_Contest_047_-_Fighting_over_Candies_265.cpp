#include<bits/stdc++.h>

using namespace std;

int main()
{
	int a,b,c;
	cin>>a>>b>>c;
	if(a+b==c||a+c==b||a==b+c)printf("Yes");
	else printf("No");
	return 0;
}