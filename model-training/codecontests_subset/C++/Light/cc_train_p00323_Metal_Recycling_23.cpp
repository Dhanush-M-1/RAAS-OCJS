#include<bits/stdc++.h>
using namespace std;
int main() {
	int n; cin >> n;
	priority_queue<int, vector<int>, greater<int>>pq;
	for (int i = 0; i<n; i++) { int a, b; cin >> a >> b; pq.push(a + b); }
	while (pq.size() > 0) {
		int p = pq.top(); pq.pop();
		if (pq.size() == 0)cout << p << " 0\n";
		else if (p == pq.top()) {
			pq.pop(); pq.push(++p);
		}
		else cout << p << " 0\n";
	}
	return 0;
}
