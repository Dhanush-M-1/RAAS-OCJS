#include<bits/stdc++.h>
using namespace std;
int main()
{
	unordered_map<string,int>m;
	int n;cin>>n;
	for(int i=0;i<n;i++) {
		string s;cin>>s;
		m[s]++;
	}
	vector<string> verdicts = {"AC", "WA", "TLE", "RE"};
	for(auto verdict: verdicts) {
		cout<<verdict << " x "<< m[verdict] << "\n";
	}
}