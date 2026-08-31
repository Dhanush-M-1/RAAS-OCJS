#include <bits/stdc++.h>
using namespace std;
const long long inf = 1e16;
vector<long long> ans(5010, inf);
long long n, m;
vector<long long> a(5010), b(5010), c(5010), d(5010);
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  long long i, j;
  cin >> n >> m;
  for (i = 0; i < m; i++) cin >> a[i] >> b[i] >> c[i] >> d[i];
  for (i = 1; i <= n; i++) {
    for (j = m - 1; j >= 0; j--) {
      if (i < b[j] || i > c[j])
        continue;
      else {
        if (a[j] == 1) {
          ans[i] -= d[j];
        } else {
          ans[i] = min(ans[i], d[j]);
        }
      }
    }
  }
  vector<long long> ANS(5010, 0);
  ANS = ans;
  for (i = 0; i < m; i++) {
    if (a[i] == 1) {
      for (j = b[i]; j <= c[i]; j++) ans[j] += d[i];
    } else {
      long long rez = -inf;
      for (j = b[i]; j <= c[i]; j++) rez = max(rez, ans[j]);
      if (rez != d[i]) {
        cout << "NO";
        return 0;
      }
    }
  }
  const long long A = 1e9 - 1;
  cout << "YES" << endl;
  for (i = 1; i <= n; i++) cout << min(ANS[i], A) << " ";
  return 0;
}
