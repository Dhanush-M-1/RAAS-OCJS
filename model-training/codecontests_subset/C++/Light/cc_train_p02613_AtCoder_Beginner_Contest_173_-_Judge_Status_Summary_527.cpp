#include <bits/stdc++.h>

using namespace std;

int main() {

	int n;

	cin >> n;

	unordered_map<string,int> d;

	for(int i=0;i<n;i++) {
		
		string t;
		cin >> t;
		d[t]++;

	}

	vector<string> con={"AC","WA","TLE","RE"};

	for(int i=0;i<con.size();i++) {

		cout<< con[i] << " x " <<d[con[i]] <<"\n";

	}
	return 0;
}