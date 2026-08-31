#include <iostream>
using namespace std;
int main(){
	int a,b;
	cin>>a>>b;
	a*=b;
	if(a%2)cout<<"Odd";
	else cout<<"Even";
	return 0;
}