#include<bits/stdc++.h>
#define rep(i,n)for(int i=0;i<n;i++)
using namespace std;

int main() {
	int q; scanf("%d", &q);
	rep(i, q) {
		int n; scanf("%d", &n);
		map<int, bool>mp;
		for (int cnt = 0;; cnt++) {
			if (n < 10) {
				printf("%d\n", cnt);
				break;
			}
			mp[n] = true;
			int Max = 0;
			string s = to_string(n);
			for (int i = 1; i < s.size(); i++) {
				string s1, s2;
				rep(j, i)s1 += s[j];
				for (int j = i; j < s.size(); j++)s2 += s[j];
				Max = max(Max, stoi(s1)*stoi(s2));
			}
			if (mp[Max]) {
				puts("-1");
				break;
			}
			n = Max;
		}
	}
}