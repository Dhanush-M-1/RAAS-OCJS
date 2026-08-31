#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    int a[n + 1];
    for (int i = 1; i <= n; i++) {
      cin >> a[i];
    }
    if (a[n] >= a[1] + a[2]) {
      cout << 1 << " " << 2 << " " << n << endl;
    } else {
      cout << -1 << endl;
    }
  }
}
