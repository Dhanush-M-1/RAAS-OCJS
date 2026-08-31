#include <iostream>
using namespace std;
int main(){
	int a,b;
	while(cin>>a>>b){
		if((a*b)%2==0)cout<<"Even";
		else cout<<"Odd";
	}
}