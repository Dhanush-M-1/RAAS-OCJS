#include <bits/stdc++.h>
using namespace std;
void solve() {
  long long n, i, x;
  cin >> n;
  vector<long long> ar;
  for (i = 0; i < n; i++) {
    cin >> x;
    ar.push_back(x);
  }
  if ((ar[0] + ar[1]) <= ar[n - 1]) {
    cout << 1 << " " << 2 << " " << n << endl;
  } else {
    cout << -1 << endl;
  }
}
int main() {
  int t;
  cin >> t;
  while (t--) {
    solve();
  }
}
