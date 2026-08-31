#include<cstdio>
#include<iostream>
using namespace std;
int a,b;
int main(){
	cin>>a>>b;
	a*=b;
	puts(a%2?"Odd":"Even");
	return 0;
}