#include <bits/stdc++.h>
using namespace std;
long long n, k, t, a, b;
vector<long long> v, va, vb;
int main() {
  cin >> n >> k;
  for (long long i = 0; i < n; i++) {
    cin >> t >> a >> b;
    if (a == 1 && b == 1)
      v.push_back(t);
    else if (a == 1 && b == 0)
      va.push_back(t);
    else if (a == 0 && b == 1)
      vb.push_back(t);
  }
  sort(v.begin(), v.end());
  sort(va.begin(), va.end());
  sort(vb.begin(), vb.end());
  long long zx = min(va.size(), vb.size());
  if ((v.size() + zx) < k) {
    cout << -1 << "\n";
    return 0;
  }
  for (long long i = 1; i < v.size(); i++) v[i] += v[i - 1];
  for (long long i = 1; i < zx; i++) {
    va[i] += va[i - 1];
    vb[i] += vb[i - 1];
  }
  long long minn = 1000000000001;
  if (v.size() >= k) minn = min(minn, v[k - 1]);
  for (long long i = 0; i < v.size(); i++) {
    long long p = k - (i + 1);
    if (zx >= p && p > 0) {
      long long cnt = v[i] + va[p - 1] + vb[p - 1];
      minn = min(minn, cnt);
    }
  }
  if (zx >= k) minn = min(minn, va[k - 1] + vb[k - 1]);
  cout << minn << "\n";
}
