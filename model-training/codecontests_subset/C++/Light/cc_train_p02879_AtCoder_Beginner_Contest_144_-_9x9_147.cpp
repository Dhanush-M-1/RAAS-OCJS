#include<iostream>
using namespace std;
int a,b;
int main(){
	cin>>a>>b;
	if (a<=9&&a>=1&&b<=9&&b>=1) cout<<a*b;
	else cout<<"-1";
	return 0;
}