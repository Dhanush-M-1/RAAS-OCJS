#include<bits/stdc++.h>
using namespace std;

string d="";
int k(int a) {
	int b = 0;
	for (; a < d.length(); a++) {
		b = b * 10 + d[a] - 48;
	}
	return b;
}
int main() {
	int a;
	cin >> a;
	for (int b = 0; b < a; b++) {
		int c = 0;
		cin >> d;
		unordered_set<string>j;
		while (c++,1) {
			if (d.length() == 1) { cout << c-1 << endl; break; }
			int MAX = 0;
			int l =0,r=k(0);
			for (int f = 0; f < d.length(); f++) {
				MAX = max(MAX, l*r);
				l = l * 10 + d[f] - 48;
				r = k(f + 1);
			}
			d = to_string(MAX);
			if (j.find(d) != j.end()) { puts("-1"); return 0; }
			j.insert(d);
		}
	}
}