#include <bits/stdc++.h>
using namespace std;

int main (void) {
	int n; string r;
	map<string, int> s;
	cin >> n;
	while (n --) {
		cin >> r;
		s[r] ++;
	}
	cout << "AC x " << s["AC"] << endl;
	cout << "WA x " << s["WA"] << endl;
	cout << "TLE x " << s["TLE"] << endl;
	cout << "RE x " << s["RE"] << endl;
}

