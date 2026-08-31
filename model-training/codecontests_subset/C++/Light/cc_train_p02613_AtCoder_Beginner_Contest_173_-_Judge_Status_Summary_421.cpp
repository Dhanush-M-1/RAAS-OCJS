#include <bits/stdc++.h>
using namespace std;

int a;

int main() {
	map<string, int> m;
	cin>>a;
	for(int k = 1; k<= a; k++){
		string s;
		cin >> s;
		m[s] ++;
	}
	cout << "AC x " << m["AC"]<< '\n';
	cout << "WA x " << m["WA"] << '\n';
	cout << "TLE x " << m["TLE"] << '\n';
	cout << "RE x " << m["RE"]<< '\n';
}