#include <bits/stdc++.h>
using namespace std;
const int MX = 80;
const long long inf = 1e15;
struct info {
  long long a, b, indx;
  bool operator<(const info& s) const { return b < s.b; }
};
long long n, c;
info ara[MX];
vector<long long> add, rem;
long long dp[MX][MX], choose[MX][MX];
long long func(long long pos, long long lim) {
  if (pos >= n) return lim ? -inf : 0;
  long long& r = dp[pos][lim];
  if (r != -1) return r;
  long long r1 = 0, r2 = 0;
  r1 = ara[pos].b * (c - 1) + func(pos + 1, lim);
  if (lim) r2 = ara[pos].a + ara[pos].b * (c - lim) + func(pos + 1, lim - 1);
  if (r1 < r2) choose[pos][lim] = 1;
  return r = max(r1, r2);
}
int main() {
  long long i, j, k;
  long long t;
  cin >> t;
  while (t--) {
    cin >> n >> c;
    for (i = 0; i < n; ++i) {
      info s;
      cin >> s.a >> s.b;
      s.indx = i + 1;
      ara[i] = s;
    }
    sort(ara, ara + n);
    memset(dp, -1, sizeof dp);
    memset(choose, 0, sizeof choose);
    func(0, c);
    long long pos = 0, lim = c;
    while (pos < n) {
      if (choose[pos][lim]) {
        add.push_back(ara[pos].indx);
        lim--;
      } else {
        rem.push_back(ara[pos].indx);
      }
      pos++;
    }
    cout << add.size() + 2 * rem.size() << endl;
    for (i = 0; i + 1 < add.size(); ++i) cout << add[i] << " ";
    for (i = 0; i < rem.size(); ++i) cout << rem[i] << " " << -rem[i] << " ";
    cout << add.back() << endl;
    add.clear(), rem.clear();
  }
}
