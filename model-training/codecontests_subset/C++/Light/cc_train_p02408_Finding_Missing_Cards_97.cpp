#include<bits/stdc++.h>
using namespace std;

int main(){
	int n,num,c[4][13]={};
	string mark;
	cin>>n;
	for(int i=0;i<n;i++){
	cin>>mark>>num;
	if(mark == "S") c[0][num-1]=1;
	if(mark == "H") c[1][num-1]=1;
	if(mark == "C") c[2][num-1]=1;
	if(mark == "D") c[3][num-1]=1;
	}
	string str[4]={"S","H","C","D"};
	for(int i=0;i<4;i++){
		for(int j=0;j<13;j++){
			if(c[i][j]==1) continue;
			cout<<str[i]<<" "<<j+1<<endl;
		}
	}
    return 0;
}
