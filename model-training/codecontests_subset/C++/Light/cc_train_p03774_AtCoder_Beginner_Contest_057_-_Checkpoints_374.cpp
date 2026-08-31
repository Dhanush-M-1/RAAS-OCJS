#include<bits/stdc++.h>
using namespace std;
int main() {
  int n, m, a[50], b[50], c[50], d[50];
  cin >> n >> m;
  for (int i = 0; i < n; i++) cin >> a[i] >> b[i];
  for (int j = 0; j < m; j++) cin >> c[j] >> d[j];
  for (int i = 0; i < n; i++) {
	int s = 1e9, k;
	for (int j = 0; j < m; j++) {
			int t = abs(a[i] - c[j]) + abs(b[i] - d[j]);
			if (s > t) s = t, k = j + 1;
	}
	cout << k << endl;
  }
}
