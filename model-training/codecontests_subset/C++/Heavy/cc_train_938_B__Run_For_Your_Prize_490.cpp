#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2,fma")
using namespace std;
int main() {
  long long t;
  t = 1;
  for (long long cs = 1; cs <= t; cs++) {
    long long m, n, b, c, d, i, j, k, x, y, z, l, r, p, q;
    string s, s1, s2, s3, s4;
    long long cnt = 0, cn = 0, ans = 0, sum = 0;
    cin >> n;
    long long a[n];
    for (long long i = 0; i < n; i++) cin >> a[i];
    vector<long long> v;
    for (long long i = 0; i < n; i++) {
      x = a[i] - 1;
      y = 1000000 - a[i];
      ans = min(x, y);
      v.push_back(ans);
    }
    sort((v).rbegin(), (v).rend());
    ans = v[0];
    cout << ans;
    printf("\n");
  }
  return 0;
}
