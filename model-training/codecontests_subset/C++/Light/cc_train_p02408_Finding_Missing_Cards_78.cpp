#include<bits/stdc++.h>
using namespace std;

int a[4][14];

int main(){
	int n;
	cin>>n;
	for(int i=1;i<=n;i++){
		char c;int p;
		cin>>c>>p;
		if(c=='S'){
			a[0][p]=1;
		}
		if(c=='H'){
			a[1][p]=1;
		}
		if(c=='C'){
			a[2][p]=1;
		}
		if(c=='D'){
			a[3][p]=1;
		}
	}
	for(int i=0;i<4;i++){
		for(int j=1;j<=13;j++){
			if(a[i][j]==0){
				if(i==0){
					cout<<"S "<<j<<endl;
				}
				if(i==1){
					cout<<"H "<<j<<endl;
				}
				if(i==2){
					cout<<"C "<<j<<endl;
				}
				if(i==3){
					cout<<"D "<<j<<endl;
				}
			}
		}
	}
	return 0;
}
