#include<bits/stdc++.h>
using namespace std;
int n;
void dfs(string s){
	if(s.size()>=n){
		cout<<s<<endl;
		return;
	}
	char mx='a';
	for(int i=0;s[i];i++)
		mx=max(mx,s[i]);
	for(char c='a';c<=mx+1;c++)
		dfs(s+c);
}
int main(){
	cin>>n;
	dfs("a");
	return 0;
}