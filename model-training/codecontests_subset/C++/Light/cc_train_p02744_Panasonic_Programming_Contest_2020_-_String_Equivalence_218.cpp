#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int n;
void dfs(int len,string now,int mx){
	if(len==n+1){
		cout<<now<<endl;
		return ;
	}
	for(int i=0;i<=mx+1&&i<len;i++){
		char x=i+'a';
		dfs(len+1,now+x,max(mx,i));
	}
}
int main(){
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin>>n;
	dfs(2,"a",0);
}