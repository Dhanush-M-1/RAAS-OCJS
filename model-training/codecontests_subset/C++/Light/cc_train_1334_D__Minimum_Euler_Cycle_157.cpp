#include <bits/stdc++.h>
using namespace std;
int main() {
  long long t;
  cin >> t;
  long long cur = 0;
  while (t--) {
    cur = 0;
    long long n, l, r;
    cin >> n >> l >> r;
    for (int i = 1; i <= n; i++) {
      if (cur + 2 * (n - i) < l)
        cur += 2 * (n - i);
      else {
        while (l <= r && i <= n && l <= cur + 2 * (n - i)) {
          if (l % 2)
            cout << i << " ";
          else
            cout << (l - cur) / 2 + i << " ";
          l++;
        }
        cur += 2 * (n - i);
      }
    }
    if (r - l == 0) cout << "1";
    cout << endl;
  }
}
