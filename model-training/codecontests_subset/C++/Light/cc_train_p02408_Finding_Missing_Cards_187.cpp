#include<cstdio>
#include<iostream>

using namespace std;

int main(void){

	int card[1000][20]={0};
	int n,l;
	char m;

	cin>>n;

	for(int i=0;i<n;i++){
		cin>>m>>l;
		card[(int)m][l]=1;
	}

	for(int i=1;i<=13;i++){
		if(card[(int)'S'][i]==0) cout<<"S "<<i<<endl;
	}
	for(int i=1;i<=13;i++){
		if(card[(int)'H'][i]==0) cout<<"H "<<i<<endl;
	}
	for(int i=1;i<=13;i++){
		if(card[(int)'C'][i]==0) cout<<"C "<<i<<endl;
	}
	for(int i=1;i<=13;i++){
		if(card[(int)'D'][i]==0) cout<<"D "<<i<<endl;
	}
	
	return 0;
}