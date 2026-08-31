#include <bits/stdc++.h>
using namespace std;
int a[4][13];
int main(){
	int n;
	cin>>n;
	for(int i=0;i<n;i++){
		char c;
		int in;
		cin>>c>>in;
		if(c=='S')a[0][in-1]=1;
		else if(c=='H')a[1][in-1]=1;
		else if(c=='C')a[2][in-1]=1;
		else a[3][in-1]=1;
	}
	for(int i=0;i<4;i++){
		for(int j=0;j<13;j++){
			if(a[0][j]==0&&i==0){
				cout<<"S "<<j+1<<endl;
			}
			if(a[1][j]==0&&i==1){
				cout<<"H "<<j+1<<endl;
			}	
			if(a[2][j]==0&&i==2){
				cout<<"C "<<j+1<<endl;
			}
			if(a[3][j]==0&&i==3){
				cout<<"D "<<j+1<<endl;
			}
		}
	}
}

