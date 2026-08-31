#include<iostream>
using namespace std;

int a,b;

int main(){
	cin>>a>>b;
	a*=b;
	if(a&1) cout<<"Odd";
	else cout<<"Even";
}