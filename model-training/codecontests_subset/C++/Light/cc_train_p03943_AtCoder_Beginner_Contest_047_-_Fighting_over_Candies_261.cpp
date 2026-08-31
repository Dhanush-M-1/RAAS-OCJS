#include <bits/stdc++.h>
using namespace std;

int main(){
	int a,b,c;
	cin>>a>>b>>c;
	
	int m=max(a,max(b,c));
	int sum=a+b+c;
	if(sum==2*m)cout<<"Yes";
	else cout<<"No";
	
}