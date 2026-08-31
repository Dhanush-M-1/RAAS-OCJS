#include <bits/stdc++.h>
using namespace std;
signed main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  long long t;
  cin >> t;
  while (t--) {
    long long n, l, r;
    cin >> n >> l >> r;
    vector<long long> lol = {0};
    for (long long i = n - 1; i >= 1; i--) {
      lol.push_back(lol.back() + 2 * i);
    }
    for (long long x = l; x <= r; x++) {
      if (x == n * (n - 1) + 1) {
        cout << 1 << ' ';
      } else {
        long long block =
            (long long)(lower_bound(lol.begin(), lol.end(), x) - lol.begin());
        if (x % 2 == 1) {
          cout << block << ' ';
        } else {
          long long h = x - lol[block - 1];
          cout << h / 2 + block << ' ';
        }
      }
    }
    cout << '\n';
  }
}
