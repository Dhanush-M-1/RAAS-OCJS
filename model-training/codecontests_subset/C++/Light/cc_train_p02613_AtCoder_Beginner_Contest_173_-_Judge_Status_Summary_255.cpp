#include<bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;
	map<string, int> freq;
	
	for(int i = 0; i < n; i++) {
		string s;
		cin >> s;
		freq[s]++;
	}
	
	for(string a: {"AC", "WA", "TLE", "RE"}) {
		cout << a << " x " << freq[a] << "\n";
	}
}
