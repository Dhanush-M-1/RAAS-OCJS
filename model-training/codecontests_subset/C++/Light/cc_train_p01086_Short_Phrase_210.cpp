#include <iostream>
#include <string>
using namespace std;

int n, p[] = { 5, 7, 5, 7, 7 }, ans;
string s[40];

int main() {
	while (true) {
		cin >> n;
		if (!n)break;
		for (int i = 0; i < n; i++) {
			cin >> s[i];
		}
		ans = 0;

		for (int i = 0; i < n; i++) {
			int index = 0;
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += s[j].length();
				if (sum == p[index]) {//次に進む
					index++;
					sum = 0;
				}
				else if (sum > p[index]) {//もうあり得ない
					break;
				}

				if (index > 4) {
					ans = i + 1;
					break;
				}
			}

			if (ans > 0)break;
		}

		cout << ans << endl;
	}
}
