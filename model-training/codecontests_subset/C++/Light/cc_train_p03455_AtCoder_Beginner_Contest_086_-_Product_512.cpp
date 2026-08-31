#include <iostream>

int main(){
	int a,b;
	std::cin>>a>>b;

	if(a*b%2==1){
		std::cout<<"Odd";
	}else{
		std::cout<<"Even";
	}
	return 0;
}
