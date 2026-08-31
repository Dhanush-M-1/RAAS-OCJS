#include<iostream>
using namespace std;
int main(){
	int n,a[4][13]={0},x;
	char y;
	cin>>n;
	for(int i=0;i<n;i++){
		cin>>y>>x;
		if(y=='S')a[0][x-1]=1;
		if(y=='H')a[1][x-1]=1;
		if(y=='C')a[2][x-1]=1;
		if(y=='D')a[3][x-1]=1;
	}
	for(int i=0;i<4;i++){
		for(int j=0;j<13;j++){
			if(a[i][j]!=1){
				if(i==0)cout<<"S "<<j+1<<endl;
				if(i==1)cout<<"H "<<j+1<<endl;
				if(i==2)cout<<"C "<<j+1<<endl;
				if(i==3)cout<<"D "<<j+1<<endl;
			}
		}
	}

	return 0;
}
