#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    vector<int> a(n);
    for (int i = 0; i < n; i++) cin >> a[i];
    int f = -1;
    for (int i = 2; i < n; i++) {
      if (a[i] >= a[0] + a[1]) {
        f = i;
        break;
      }
    }
    if (f == -1) {
      cout << -1 << '\n';
    } else {
      cout << 1 << ' ' << 2 << ' ' << (f + 1) << '\n';
    }
  }
}
