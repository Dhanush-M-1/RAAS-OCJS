// B - Judge Status Summary
#include <bits/stdc++.h>
using namespace std;

int main(){
	int N; cin>>N;
	vector<string> S(N);
	for(int i=0; i<N; ++i) cin>>S[i];
	for(auto k:{"AC","WA","TLE","RE"})
		cout<< k <<" x "<< count(S.begin(),S.end(),k) <<endl;
}
