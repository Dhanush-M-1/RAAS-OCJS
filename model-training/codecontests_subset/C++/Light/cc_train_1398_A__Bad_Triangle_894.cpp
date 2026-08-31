#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e9;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }
    if (a[0] + a[1] <= a[n - 1]) {
      cout << 1 << " " << 2 << " " << n << '\n';
    } else {
      cout << -1 << '\n';
    }
  }
  return 0;
}
