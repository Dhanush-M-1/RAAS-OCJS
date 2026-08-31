#include <bits/stdc++.h>
using namespace std;

int main() {
	map <string, int> m;
	long long n;
	string s;
	cin >> n;
	while(n--){
		cin >> s;
		m[s]++;
	}
	cout << "AC x " << m["AC"] << '\n';
	cout << "WA x " << m["WA"] << '\n';
	cout << "TLE x " << m["TLE"] << '\n';
	cout << "RE x " << m["RE"] << '\n';
}