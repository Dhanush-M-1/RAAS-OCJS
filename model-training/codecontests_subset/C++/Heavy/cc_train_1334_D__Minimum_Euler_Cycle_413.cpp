#include <bits/stdc++.h>
using namespace std;
int T, n;
long long l, r;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> T;
  while (T > 0) {
    --T;
    cin >> n >> l >> r;
    long long s = 0;
    for (int i = 1; i <= n; ++i) {
      long long t = s + 1ll * 2 * (n - i);
      if (t < l) {
        s = t;
        continue;
      }
      if (s < l && t >= l) {
        if (l % 2 == 1) {
          int L = (l - s) / 2 + 1 + i;
          if (t >= r) {
            int R = (r - s) / 2 + i;
            for (int j = L; j <= R; ++j) {
              cout << i << " " << j << " ";
            }
            if ((r - s) % 2 == 1) cout << i << " ";
            s = t;
            break;
          }
          for (int j = L; j <= n; ++j) {
            cout << i << " " << j << " ";
          }
        } else {
          int L = (l - s) / 2 + i;
          cout << L << " ";
          if (t >= r) {
            int R = (r - s) / 2 + i;
            for (int j = L + 1; j <= R; ++j) {
              cout << i << " " << j << " ";
            }
            if ((r - s) % 2 == 1) cout << i << " ";
            s = t;
            break;
          }
          for (int j = L + 1; j <= n; ++j) {
            cout << i << " " << j << " ";
          }
        }
        s = t;
        continue;
      }
      if (t < r) {
        for (int j = i + 1; j <= n; ++j) {
          cout << i << " " << j << " ";
        }
        s = t;
        continue;
      }
      if (s < r && t >= r) {
        int R = (r - s) / 2 + i;
        for (int j = i + 1; j <= R; ++j) {
          cout << i << " " << j << " ";
        }
        if ((r - s) % 2 == 1) cout << i << " ";
        s = t;
      }
    }
    if (s < r) cout << 1;
    cout << '\n';
  }
  return 0;
}
