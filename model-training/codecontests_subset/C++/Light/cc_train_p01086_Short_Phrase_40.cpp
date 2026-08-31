#include<iostream>
#include<string>
#include<vector>
using namespace std;

int main() {
	int n;
	int q = 0;
	while (cin >> n) {
		if (q != 0)cout << endl;
		if (n == 0)return 0;
		string w[50];
		for (int i = 0;i < n;i++)cin >> w[i];
		vector<int>v;
		int now = 0;
		for (int i = 0;i < n - 1;i++) {
			for (int j = i;j < n;j++) {
				now += w[j].size();
				if (now == 5) {
					v.push_back(i);
					now = 0;
					break;
				}
				if (now >= 6) {
					now = 0;
					break;
				}
			}
		}
		now=0;
		int k = 0, flag = 0;
		int haiku[5] = { 5,7,5,7,7 };
		for (int i = 0;i < v.size();i++) {
			for (int j = v[i];j < n;j++) {
				now += w[j].size();
				if (now == haiku[k]) {
					k++;
					now = 0;
				}
				if (k == 5) {
					cout << v[i] + 1;
					q++;
					flag = 1;
					break;
				}
			}
			if (flag)break;
			now = 0;
			k = 0;
		}
	}
}
