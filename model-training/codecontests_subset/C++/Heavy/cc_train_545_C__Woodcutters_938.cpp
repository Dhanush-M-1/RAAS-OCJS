#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e5 + 10;
int ans = 1;
long long x[maxn], h[maxn];
int main() {
  long long n, frb;
  cin >> n;
  for (int i = 0; i < n; i++) cin >> x[i] >> h[i];
  x[n] = (long long)1000 * 1000 * 1000 * 1000;
  frb = x[0];
  for (int i = 1; i < n; i++) {
    if (x[i] - h[i] > frb)
      frb = x[i], ans++;
    else {
      if (x[i] + h[i] >= x[i + 1]) {
        frb = x[i];
        continue;
      } else {
        if (x[i] + h[i] < x[i + 1] - h[i + 1]) {
          ans++;
          frb = x[i] + h[i];
          continue;
        } else {
          frb = x[i] + h[i];
          ans++;
          continue;
        }
      }
    }
  }
  cout << ans;
}
