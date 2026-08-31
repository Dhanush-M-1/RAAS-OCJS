#include<iostream>
int main(){
	int n,minj,ret=0,b1,b2,list[101];
	bool isrev=true;
	std::cin>>n;
	for(int i=0;i<n;i++){
		std::cin>>list[i];
	}
	for(int i=0;i<n;i++){
		minj=i;
		for(int j=i;j<n;j++){
			if(list[j]<list[minj])minj=j;
		}
		b1=list[i],b2=list[minj];
		list[i]=b2,list[minj]=b1;
		if(i!=minj)ret++;
	}
	for(int i=0;i<n;i++){
		std::cout<<list[i];
		if(i!=n-1)std::cout<<" ";
		else std::cout<<"\n";
	}
	std::cout<<ret<<"\n";
	return 0;
}