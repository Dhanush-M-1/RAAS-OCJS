#include <bits/stdc++.h>
using namespace std;

int main(){
	
	int flg[4][14]={};
	int p[256];
	p['S']=0;
	p['H']=1;
	p['C']=2;
	p['D']=3;
	char e[5]="SHCD";
	int n;
	cin>>n;
	while(n--){
		char c;
		int r;
		cin>>c>>r;
		flg[p[c]][r]=1;
	}
	for(int i=0;i<4;i++){
		for(int j=1;j<=13;j++){
			if(flg[i][j]==0){
				cout<<e[i]<<" "<<j<<endl;
			}
		}
	}
	
	return 0;
}
