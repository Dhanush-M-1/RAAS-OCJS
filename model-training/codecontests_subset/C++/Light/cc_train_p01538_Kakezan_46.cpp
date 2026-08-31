#include <bits/stdc++.h>
using namespace std;

int main() {
	int q, n;
	cin >> q;
	for(int i = 0; i < q; ++i){
		cin >> n;
		int cnt = 0;
		while(cnt < 1000){
			if(n <= 9)
				break;
			string base = to_string(n);
			int next = 0;
			for(int i = 1; i < base.size(); ++i){
				string t = base;
				int l = stoi(t.substr(0, i));
				int r = stoi(t.substr(i, t.size() - i));
				next = max(next, l * r);
			}
			n = next;
			cnt++;
		}
		if(cnt >= 1000)
			cout << "-1" << endl;
		else
			cout << cnt << endl;
	}
	return 0;
}