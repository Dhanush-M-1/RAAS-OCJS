#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n, res;
	while (cin >> n, n) {
		vector<int> v;
		v.reserve(n);
		for (int i = 0, tmp; i < n; i++) {
			cin >> tmp;
			v.push_back(tmp);
		}
		bool flag = true;
		res = 0;
		while (flag) {
			flag = false;
			for (int i = 0, tmp;i < v.size() - 1;i++) {
				if (v[i] > v[i + 1]) {
					tmp = v[i];
					v[i] = v[i + 1];
					v[i + 1] = tmp;
					flag = true;
					res++;
				}
			}
		}
		cout << res << endl;
	}
	return 0;
}