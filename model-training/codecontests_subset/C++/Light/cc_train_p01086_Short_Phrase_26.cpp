#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int n;
string s[40];

bool find(int st) {
	int cnt[5] = {5, 7, 5, 7, 7};
	int cor = 0;
	
	for (int i = st; i < n; i++) {
		cnt[cor] -= (int)s[i].length();
		if (cnt[cor] < 0) return false;
		if (cnt[cor] == 0) cor++;
		if (cor == 5) return true;
	}
	return false;
}

int main() {
	while (cin >> n) {
		if (!n) break;
		int i, j;
		
		for (i = 0; i < n; i++) cin >> s[i];
		
		for (i = 0; ; i++) {
			if (find(i)) {
				break;
			}
		}
		cout << i + 1 << endl;
	}
	return 0;
}