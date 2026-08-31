// D - String Equivalence
// DFS version
#include <bits/stdc++.h>
using namespace std;

int N;

void dfs(string pre){
	if(pre.size() >= N){ cout<< pre <<endl; return; }
	char mx = *max_element(pre.begin(), pre.end()) + 1;
	for(char c='a'; c<=mx; ++c) dfs(pre+c);
}

int main(){
	cin>>N;
	dfs("a");
}