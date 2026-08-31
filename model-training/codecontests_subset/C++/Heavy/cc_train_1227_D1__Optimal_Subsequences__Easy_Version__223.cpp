#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, m;
  cin >> n;
  long long x[n + 5];
  for (long long i = 0; i < n; i++) {
    cin >> x[i];
  }
  cin >> m;
  long long ans = 1e+18;
  deque<long long> y, z;
  for (long long j = 0; j < m; j++) {
    long long k, pos;
    cin >> k >> pos;
    y.clear();
    z.clear();
    for (long long i = 0; i < n; i++) {
      if (i < k) {
        y.push_back(x[i]);
        z.push_back(x[i]);
      } else {
        sort(z.begin(), z.end());
        if (x[i] > z[0]) {
          for (long long r = k - 1; r >= 0; r--) {
            if (y[r] == z[0]) {
              y.erase(y.begin() + r);
              break;
            }
          }
          z.pop_front();
          z.push_back(x[i]);
          y.push_back(x[i]);
        }
      }
    }
    cout << y[pos - 1] << endl;
  }
}
