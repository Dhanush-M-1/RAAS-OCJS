#include<bits/stdc++.h>
using namespace std;

int main() {
	int a,b,c;
	cin>>a>>b>>c;
	if(a+b==c || a==b+c || b==a+c) printf("Yes\n");
	else printf("No\n");
	return 0;
}