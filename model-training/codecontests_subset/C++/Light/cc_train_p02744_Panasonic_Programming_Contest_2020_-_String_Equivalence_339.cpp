// D - String Equivalence
// DFS version
#include <bits/stdc++.h>
using namespace std;

int N;

void dfs(string pre){
	if(pre.size() >= N){
		cout<< pre <<endl;
		return;
	}
	char mx='a'; for(auto c:pre) mx = max(mx, char(c+1));
	for(char c='a'; c<=mx; ++c) dfs(pre+c);
}

int main(){
	cin>>N;
	dfs("a");
}