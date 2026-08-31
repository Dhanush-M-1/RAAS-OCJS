#include<iostream>
using namespace std;
int main(){
	int x,n,i,c[4][13]={0},j;
	char m;
	cin>>n;
	for(i=1;i<=n;i++){
		cin>>m>>x;
		if(m=='S'){
			c[0][x-1]=1;
		}else if(m=='H'){
			c[1][x-1]=1;
		}else if(m=='C'){
			c[2][x-1]=1;
		}else if(m=='D'){
			c[3][x-1]=1;
		}
	}
	for(i=0;i<4;i++){
		for(j=0;j<13;j++){
			if(c[i][j]==0){
				if(i==0){
					cout<<"S "<<j+1<<endl;
				}else if(i==1){
					cout<<"H "<<j+1<<endl;
				}else if(i==2){
					cout<<"C "<<j+1<<endl;
				}else{
					cout<<"D "<<j+1<<endl;
				}
			}
		}
	}
	return 0;
}