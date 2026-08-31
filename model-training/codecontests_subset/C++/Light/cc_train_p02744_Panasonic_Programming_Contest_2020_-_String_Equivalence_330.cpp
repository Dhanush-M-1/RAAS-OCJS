#include <bits/stdc++.h>

using namespace std;
int N;
void dfs(string s,char m){
	if(s.size()==N){
		cout<<s.c_str()<<"\n";
	}
	else{
		for (char i='a';i<=m;++i){
			dfs(s+i,((i==m)?(char)(m+1):m));
		}
	}
}
int main(){
	cin>>N;
	dfs("",'a');
	return 0;
}
