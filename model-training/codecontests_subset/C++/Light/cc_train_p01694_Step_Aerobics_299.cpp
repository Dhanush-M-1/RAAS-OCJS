#include <bits/stdc++.h>
using namespace std;

int main(){
	map<string,int>M;
	M["lu"]=1;
	M["ru"]=2;
	M["ld"]=-1;
	M["rd"]=-2;
	for(int n;cin>>n,n;){
		int ans=0,asi=0,k=n,nx=3;
		for(string s;k--;){
			cin>>s;
			asi+=M[s];
			if(asi==nx){
				nx=(nx==0?3:0);
				ans++;
			}
		}
		cout<<ans<<endl;
	}
	
	return 0;
}
