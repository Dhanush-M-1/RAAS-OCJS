#include<bits/stdc++.h>
using namespace std;
int main()
{
	int a,b;
	cin>>a>>b;
	cout<<(min(a,b)>=1 && max(a,b)<=9?a*b:-1)<<"\n";
	return 0;
}