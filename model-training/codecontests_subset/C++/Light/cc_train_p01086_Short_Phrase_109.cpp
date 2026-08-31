#include <bits/stdc++.h>
using namespace std;

#define for_(i,a,b) for(int i=(a);i<(b);++i)

const int len[6] = {5,7,5,7,7,-1};

int main() {
	int n;
	while (cin >> n) {
		if (n == 0) break;
		vector< string > s(n);
		for_(i,0,n) cin >> s[i];
		
		for_(i,0,n) {
			int p = 0, sum = 0;
			for_(j,i,n) {
				sum += s[j].size();
				if (sum > len[p]) break;
				if (sum == len[p]) {
					sum = 0;
					++p;
				}
			}
			
			if (p == 5) {
				cout << i + 1 << endl;
				break;
			}
		}
	}
}