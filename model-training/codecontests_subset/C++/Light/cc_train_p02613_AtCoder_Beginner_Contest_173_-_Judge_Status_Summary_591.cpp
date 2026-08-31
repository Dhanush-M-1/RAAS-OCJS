// B - Judge Status Summary
#include <bits/stdc++.h>
using namespace std;
string in(){string x;cin>>x;return x;}

int main(){
	int N; cin>>N;
	map<string,int> S;
	while(N--) S[in()]++;
	for(auto k:{"AC","WA","TLE","RE"})
		cout<< k <<" x "<< (S.count(k)? S[k]:0) <<endl;
}
