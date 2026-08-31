#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC optimize("O3")
#pragma GCC optimize("unroll-loops")
using namespace std;
long long N = 1234567891, M = 31;
long long n, m, t, k, f, mi = 2e9, x, y, z, ma, x3, x2, y2, l, r, i, j, ans, vv,
                         a2[410000], d[410000], dp[810000];
string s, s2, s3;
vector<long long> v, v2, v3;
struct pos {
  long long x, y, z;
};
pos a[410000], b[410000];
bool cmp(pos l, pos r) {
  if (l.x == r.x) return l.y > r.y;
  return l.x < r.x;
}
void upd(int l, int r, int x, int ve) {
  if (l == r) {
    dp[ve] = 1;
    return;
  }
  int t = (l + r) / 2;
  if (t >= x)
    upd(l, t, x, ve * 2);
  else
    upd(t + 1, r, x, ve * 2 + 1);
  dp[ve] = dp[ve * 2] + dp[ve * 2 + 1];
}
int sum(int l, int r, int x, int ve) {
  if (l == r) return l;
  int t = (l + r) / 2;
  if (dp[ve * 2] >= x) return sum(l, t, x, ve * 2);
  return sum(t + 1, r, x - dp[ve * 2], ve * 2 + 1);
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> n;
  for (i = 1; i <= n; i++) {
    cin >> a[i].x;
    a2[i] = a[i].x;
    a[i].y = i;
  }
  sort(a + 1, a + n + 1, cmp);
  cin >> m;
  for (i = 1; i <= m; i++) {
    cin >> b[i].x >> b[i].y;
    b[i].z = i;
  }
  sort(b + 1, b + m + 1, cmp);
  for (i = 1; i <= m; i++) {
    for (j = b[i - 1].x + 1; j <= b[i].x; j++) {
      l = a[n - j + 1].y;
      upd(1, n, l, 1);
    }
    d[b[i].z] = a2[sum(1, n, b[i].y, 1)];
  }
  for (i = 1; i <= m; i++) {
    cout << d[i] << endl;
  }
}
