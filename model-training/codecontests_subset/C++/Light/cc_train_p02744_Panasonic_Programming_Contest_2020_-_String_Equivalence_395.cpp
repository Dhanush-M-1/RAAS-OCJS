// D - String Equivalence
#include <bits/stdc++.h>
using namespace std;

int main(){
	int N; cin>>N;
	set<string> s{"a"};
	while(--N){
		set<string>t; swap(s,t);
		for(auto pre:t){
			char mx='a'; for(auto c:pre) mx = max(mx, c); mx++;
			for(char c='a'; c<=mx; ++c) s.insert(pre + string(1,c));
		}

	}
	for(auto x:s) cout<< x <<endl;
}