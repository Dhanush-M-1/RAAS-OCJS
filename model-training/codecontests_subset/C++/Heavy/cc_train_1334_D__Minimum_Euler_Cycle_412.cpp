#include <bits/stdc++.h>
using namespace std;
void file() {}
signed main() {
  ios::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  ;
  long long t;
  cin >> t;
  while (t--) {
    long long n, l, r;
    cin >> n >> l >> r;
    vector<long long> a;
    long long cnt = 0, flag = 0;
    for (long long i = 1; i <= n && cnt < r; i++) {
      if (cnt < l && l <= cnt + (n - i) * 2) {
        flag = 1;
      }
      if (flag) {
        for (long long j = i + 1; j <= n; j++) {
          a.push_back(i);
          cnt++;
          if (cnt == r) break;
          a.push_back(j);
          cnt++;
          if (cnt == r) break;
        }
      } else
        cnt += (n - i) * 2;
    }
    if (r == n * (n - 1) + 1) a.push_back(1);
    long long len = a.size();
    for (long long i = len - (r - l + 1); i < len; i++) cout << a[i] << " ";
    cout << "\n";
  }
  return 0;
}
