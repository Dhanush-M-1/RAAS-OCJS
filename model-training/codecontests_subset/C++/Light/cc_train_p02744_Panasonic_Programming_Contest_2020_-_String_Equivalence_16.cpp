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
	set<char> types{'a'}; for(auto c:pre) types.insert(c+1);
	for(auto c:types) dfs(pre+c);
}

int main(){
	cin>>N;
	dfs("a");
}