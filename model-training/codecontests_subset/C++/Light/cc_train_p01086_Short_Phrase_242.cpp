#include <iostream>
#include <functional>
#include <algorithm>
#include <string>
using namespace std;
int num[5] = { 5,7,5,7,7 };
int main() {
	int n;
	int w[53];
	while (1) {
		cin >> n;
		if (n == 0)break;
		string s;
		for (int i = 0; i < n; i++) {
			cin >> s;
			w[i] = s.length();
		}
		for (int i = 0; i < n; i++) {
			int now = i;
			int x = 0;
			int cnt = 0;
			int judge = 0;
			while (1) {
				if (x == 5) {
					judge = 1;
					break;
				}
				cnt += w[now++];
				if (cnt == num[x]) {
					cnt = 0;
					x += 1;
				}
				if (cnt > num[x] || (now >= n&&x!=5))break;
			}
			if (judge == 1) {
				cout << i + 1 << "\n";
				break;
			}
		}
	}
}
