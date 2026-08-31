#include<bits/stdc++.h>
using namespace std;
int a,n;
int main()
{
	cin>>n>>a;
	n=n*a;
	if(n%2) cout<<"Odd";
	else cout<<"Even";
	return 0;
}