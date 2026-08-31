#include <bits/stdc++.h>
using namespace std;
void solve() {
  long long n, k;
  cin >> n >> k;
  vector<long long> v1, v2;
  vector<long long> v;
  for (long long i = 0; i < n; i++) {
    long long t1, a, b;
    cin >> t1 >> a >> b;
    if (a == 1) {
      if (b == 1)
        v.push_back(t1);
      else
        v1.push_back(t1);
    } else if (b == 1) {
      v2.push_back(t1);
    }
  }
  if ((v1.size() + v.size() < k) || (v2.size() + v.size() < k)) {
    cout << "-1";
    return;
  }
  sort(v1.begin(), v1.end());
  sort(v2.begin(), v2.end());
  sort(v.begin(), v.end());
  long long t = 0, cnt = 0, i = 0, j = 0;
  while (cnt < k) {
    if (i < v1.size() && i < v2.size()) {
      if (j < v.size()) {
        if (v1[i] + v2[i] >= v[j]) {
          t += v[j];
          cnt++;
          j++;
        } else {
          t += v1[i];
          t += v2[i];
          cnt++;
          i++;
        }
      } else {
        long long c = cnt, p = i;
        while (c < k) {
          t += v1[i];
          i++;
          c++;
        }
        while (cnt < k) {
          t += v2[p];
          p++;
          cnt++;
        }
      }
    } else {
      while (cnt < k) {
        t += v[j];
        cnt++;
        j++;
      }
    }
  }
  cout << t;
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long t = 1;
  while (t--) {
    solve();
  }
}
