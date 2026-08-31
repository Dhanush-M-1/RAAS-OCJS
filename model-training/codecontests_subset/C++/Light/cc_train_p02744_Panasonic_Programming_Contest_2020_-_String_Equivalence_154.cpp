// D - String Equivalence
#include <bits/stdc++.h>
using namespace std;

int main(){
	int N; cin>>N;
	set<string> s{"a"};
	while(--N){
		set<string>t; swap(s,t);
		for(auto pre:t){
			set<char> types{'a'}; for(auto c:pre) types.insert(c+1);
			for(auto c:types) s.insert(pre + c);
		}
	}
	for(auto x:s) cout<< x <<endl;
}