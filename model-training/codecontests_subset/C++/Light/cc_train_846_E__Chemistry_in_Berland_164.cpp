#include <bits/stdc++.h>
using namespace std;
const int maxn = 100005;
const long long thr = 200000000000000000;
long long a[maxn], b[maxn], x[maxn], k[maxn];
int main() {
  ios_base::sync_with_stdio(false);
  int n;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> b[i];
  }
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
  }
  for (int i = 2; i <= n; i++) {
    cin >> x[i] >> k[i];
  }
  for (int i = n; i >= 2; i--) {
    if (b[i] >= a[i]) {
      b[x[i]] += b[i] - a[i];
    } else {
      long long diff = a[i] - b[i];
      long long ex = b[x[i]];
      if (b[x[i]] < -thr) {
        cout << "NO" << endl;
        return 0;
      }
      if (log(ex + thr) < log(k[i]) + log(diff)) {
        cout << "NO" << endl;
        return 0;
      }
      b[x[i]] -= k[i] * diff;
    }
  }
  if (b[1] >= a[1]) {
    cout << "YES" << endl;
  } else {
    cout << "NO" << endl;
  }
  return 0;
}
