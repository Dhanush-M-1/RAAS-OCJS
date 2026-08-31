#include<bits/stdc++.h>
using namespace std;
double d[10];
string s;
void f() {
	s += ',';
	bool b00l = 0;
	int cnt = 0;
	double p = 0, sig = 1, pk = 1;
	for (char ch : s) {
		if (ch == ',') {
			d[cnt] = p * sig;
			p = 0; sig = 1; cnt++;
			b00l = 0; pk = 1;
		}
		else if (ch == '-')sig = -1;
		else if (ch == '.') b00l = 1;
		else if (b00l) {
			pk /= 10;
			p += pk * (ch - '0');
		}
		else p = p * 10 + ch - '0';
	}
}
signed main() {
	while (cin >> s) {
		f();
		if (((d[0] - d[4]) * (d[3] - d[1]) - (d[1] - d[5]) * (d[2] - d[0])) * ((d[0] - d[4]) * (d[7] - d[1]) - (d[1] - d[5]) * (d[6] - d[0])) > 0)cout << "NO\n"; else
		if (((d[2] - d[6]) * (d[1] - d[3]) - (d[3] - d[7]) * (d[0] - d[2])) * ((d[2] - d[6]) * (d[5] - d[3]) - (d[3] - d[7]) * (d[4] - d[2])) > 0)cout << "NO\n";
		else cout << "YES\n";//0145<=>2367
	}
}
