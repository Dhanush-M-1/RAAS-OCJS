#include<bits/stdc++.h>
using namespace std;

typedef long long ll;
typedef pair<ll,ll> P;

int n;

void dfs(string s,char tmp){
	if(s.size()==n){
		cout<<s<<endl;
		return;
	}else{
		for(char c='a';c<=tmp+1;c++){
			string t=s;
			t+=c;
			dfs(t,max(c,tmp));
		}
	}
}

int main() {
	cin>>n;
	dfs("",'a'-1);
	return 0;
}
