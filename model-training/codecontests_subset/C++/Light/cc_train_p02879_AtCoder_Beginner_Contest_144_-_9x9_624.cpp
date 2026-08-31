#include<iostream>
using namespace std;

int main(){
	int a,b;
	cin>>a>>b;
	(a>9||b>9)?(cout<<"-1\n"):(cout<<a*b<<"\n");
	return 0;	
}