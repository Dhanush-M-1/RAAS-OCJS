// D - String Equivalence
// DFS version
#include <bits/stdc++.h>
using namespace std;

int N;

void dfs(string pre, char cmax){
	if(pre.size() >= N) cout<< pre <<endl;
	else for(char c='a'; c<=cmax; ++c) dfs(pre + c, (c<cmax? cmax: cmax + 1));
}

int main(){
	cin>>N;
	dfs("", 'a');
}