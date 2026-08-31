#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	string tmp;
	while (cin >> n, n) {
		vector<string> v;
		v.reserve(n);
		for (int i = 0; i < n; i++) {
			cin >> tmp;
			v.push_back(tmp);
		}
		int del = 0;
		int flag = 0;
		while (flag != 5) {
			flag = 0;
			int length = 0;
			for (int i = del;i < v.size();i++) {
				length += v[i].size();
				if (length == 5 || length == 12 || length == 17 || length == 24 || length == 31)
					flag++;
			}
			del++;
		}
		cout << del << endl;
	}
	return 0;
}