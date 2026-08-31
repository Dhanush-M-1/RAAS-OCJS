#include <bits/stdc++.h>
using namespace std;
const int mod = 1e9 + 7;
const long long inf = 1e18;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long n, d;
  cin >> n >> d;
  long long v[n];
  long long a[n], ck[n];
  memset(ck, 0, sizeof ck);
  for (long long i = (0); i < (n); i++) {
    cin >> a[i];
    if (i)
      v[i] = v[i - 1] + a[i];
    else
      v[i] = a[i];
    if (!a[i]) ck[i] = 1;
  }
  long long k = *max_element(v, v + n);
  if (k > d) {
    cout << -1;
    return 0;
  }
  long long lazy = 0, ans = 0;
  for (long long i = (0); i < (n); i++) {
    if (ck[i]) {
      if (v[i] + lazy < 0) {
        k = max_element(v + i, v + n) - v;
        long long inc = 0;
        inc = d - (v[k] + lazy);
        v[i] += (inc + lazy);
        if (v[i] < 0) {
          cout << -1;
          return 0;
        }
        ans++;
        lazy += inc;
      }
    }
    if (v[i] > d) {
      cout << -1;
      return 0;
    }
  }
  cout << ans;
  return 0;
}
