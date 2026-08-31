#include<iostream>
#include<string>
using namespace std;
string S[1000]; int  n, p[5] = { 5,12,17,24,31 };
int main() {
	while (true) {
		cin >> n; if (n == 0)break;
		for (int i = 0; i < n; i++)cin >> S[i];
		for (int i = 0; i < n; i++) {
			int cnt = 0, sum = 0;
			for (int j = i; j < n; j++) {
				if (cnt >= 5)continue;
				sum += S[j].size();
				if (p[cnt] == sum)cnt++;
			}
			if (cnt == 5) { cout << i + 1 << endl; break; }
		}
	}
	return 0;
}