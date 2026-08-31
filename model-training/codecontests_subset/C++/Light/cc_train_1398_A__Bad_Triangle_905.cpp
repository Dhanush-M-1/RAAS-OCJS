#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 5;
int a[N];
int solve() {
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) cin >> a[i];
  int i = 0, j = 1, k = 2;
  long long sum = a[i] + a[j];
  for (int k = 2; k < n; k++) {
    if (a[k] >= sum) {
      cout << "1 2 " << k + 1 << endl;
      return k;
    }
  }
  cout << -1 << endl;
}
int main() {
  int t = 1;
  cin >> t;
  while (t--) {
    solve();
  }
  return 0;
}
