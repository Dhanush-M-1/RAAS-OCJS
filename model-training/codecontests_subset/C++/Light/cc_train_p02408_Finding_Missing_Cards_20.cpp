#include<bits/stdc++.h>
using namespace std;

int main(){
	int cards[4][13]={0};
	int n;
	cin>>n;
	for(int i=0;i<n;i++){
	char a;
	int b;
	cin>>a>>b;
	if(a=='S')cards[0][b-1]++;
	else if(a=='H')cards[1][b-1]++;
	else if(a=='C')cards[2][b-1]++;
	else if(a=='D')cards[3][b-1]++;
	}
	for(int i=0;i<4;i++){
		for(int j=0;j<13;j++){
			if(cards[i][j]==0){
				if(i==0)cout<<"S "<<j+1<<endl;
				if(i==1)cout<<"H "<<j+1<<endl;
				if(i==2)cout<<"C "<<j+1<<endl;
				if(i==3)cout<<"D "<<j+1<<endl;
				
				}
			
			}
		
		}
	
	
	
}
