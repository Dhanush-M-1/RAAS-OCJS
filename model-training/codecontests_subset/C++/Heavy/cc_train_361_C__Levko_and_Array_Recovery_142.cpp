#include <bits/stdc++.h>
using namespace std;
template <typename T>
T abs(T x) {
  return x > 0 ? x : -x;
}
const long long inf = 1e9;
long long a[5005];
long long b[5005];
pair<pair<long long, long long>, pair<long long, long long> > q[5005];
int main() {
  int n, m;
  cin >> n >> m;
  for (int i = 0; i < m; i++) {
    cin >> q[i].first.first >> q[i].second.first >> q[i].second.second >>
        q[i].first.second;
  }
  for (int i = 1; i <= n; i++) a[i] = inf;
  for (int i = m - 1; i >= 0; i--) {
    if (q[i].first.first == 1) {
      for (int j = q[i].second.first; j <= q[i].second.second; j++) {
        a[j] -= q[i].first.second;
      }
    } else {
      for (int j = q[i].second.first; j <= q[i].second.second; j++) {
        a[j] = min(a[j], q[i].first.second);
      }
    }
  }
  for (int i = 1; i <= n; i++) a[i] = b[i] = min(inf, a[i]);
  for (int i = 0; i < m; i++) {
    if (q[i].first.first == 1) {
      for (int j = q[i].second.first; j <= q[i].second.second; j++) {
        a[j] += q[i].first.second;
      }
    } else {
      long long mm = -inf;
      for (int j = q[i].second.first; j <= q[i].second.second; j++) {
        mm = max(mm, a[j]);
      }
      if (mm != q[i].first.second) {
        cout << "NO";
        return 0;
      }
    }
  }
  for (int i = 0; i < n; i++) {
    if (abs(a[i]) > inf) {
      cout << "NO";
      return 0;
    }
  }
  cout << "YES" << endl;
  for (int i = 1; i <= n; i++) {
    if (i != 1) cout << " ";
    cout << b[i];
  }
  return 0;
}
