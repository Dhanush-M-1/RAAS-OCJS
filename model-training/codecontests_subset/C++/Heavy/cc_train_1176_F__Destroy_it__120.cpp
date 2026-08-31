#include <bits/stdc++.h>
using namespace std;
const long long LEN = (long long)2e5;
int n;
array<long long, 5> a;
array<long long, 10> dp, dpn;
array<array<long long, 2>, 4> z;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cin >> n;
  for (int I = 0; I < n; I++) {
    int k;
    cin >> k;
    fill(a.begin(), a.end(), 0);
    for (auto& i : z) fill(i.begin(), i.end(), 0);
    while (k--) {
      long long c, d;
      cin >> c >> d;
      if (c == 1) {
        auto& ch = *min_element(a.begin(), a.begin() + 3);
        ch = max(ch, d);
      } else
        a[c + 1] = max(a[c + 1], d);
    }
    sort(a.begin(), a.begin() + 3);
    z[1][0] = *max_element(a.begin(), a.end());
    z[1][1] = 2LL * z[1][0];
    for (int i = 1; i < 4; i += 2)
      if (a[2] && a[i]) {
        z[2][0] = max(z[2][0], a[2] + a[i]);
        z[2][1] = max(z[2][1], a[2] + a[i] + max(a[2], a[i]));
      }
    if (a[0]) {
      z[3][0] = a[0] + a[1] + a[2];
      z[3][1] = z[3][0] + *max_element(a.begin(), a.begin() + 3);
    }
    for (int j = 0; j <= 9; j++)
      for (int q = 1; q <= 3; q++) {
        int k = j - q, w = 0;
        if (k < 0) {
          k += 10;
          w = 1;
        }
        if ((z[q][w] > 0) && ((dp[k] > 0) || (k == 0)))
          dpn[j] = max(dpn[j], dp[k] + z[q][w]);
      }
    copy(dpn.begin(), dpn.end(), dp.begin());
    ;
    ;
    ;
    ;
    ;
    ;
    ;
    ;
    ;
    ;
  }
  cout << *max_element(dp.begin(), dp.end());
  return 0;
}
