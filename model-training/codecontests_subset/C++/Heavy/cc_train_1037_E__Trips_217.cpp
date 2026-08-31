#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 100;
vector<int> v[maxn];
pair<long long, long long> a[maxn];
long long q[maxn], siz[maxn];
bool c[maxn];
long long n, m, k;
set<pair<long long, long long> > s;
map<pair<long long, long long>, bool> mark;
int main() {
  ios_base::sync_with_stdio(false);
  cin >> n >> m >> k;
  for (long long y = 0; y < m; y++) {
    cin >> a[y].first >> a[y].second;
    v[a[y].first].push_back(a[y].second), v[a[y].second].push_back(a[y].first);
    siz[a[y].second]++, siz[a[y].first]++;
  }
  for (long long y = 1; y <= n; y++)
    s.insert(pair<long long, long long>(siz[y], y));
  for (long long y = m - 1; y >= 0; y--) {
    if (y != m - 1 && !mark[a[y + 1]]) {
      mark[pair<long long, long long>(a[y + 1].second, a[y + 1].first)] =
          mark[pair<long long, long long>(a[y + 1].first, a[y + 1].second)] = 1;
      long long i = a[y + 1].second;
      siz[i]--;
      if (c[i] == 0) {
        pair<long long, long long> x =
            pair<long long, long long>(siz[i] + 1, i);
        s.erase(x);
        x.first--;
        s.insert(x);
      }
      i = a[y + 1].first;
      siz[i]--;
      if (c[i] == 0) {
        pair<long long, long long> x =
            pair<long long, long long>(siz[i] + 1, i);
        s.erase(x);
        x.first--;
        s.insert(x);
      }
    }
    while (s.size() != 0) {
      pair<long long, long long> x = *s.begin();
      if (x.first >= k) break;
      s.erase(x);
      c[x.second] = 1;
      for (long long ii = 0; ii < v[x.second].size(); ii++) {
        long long i = v[x.second][ii];
        if (!mark[pair<long long, long long>(x.second, i)]) {
          mark[pair<long long, long long>(x.second, i)] =
              mark[pair<long long, long long>(i, x.second)] = 1;
          siz[i]--;
          siz[x.second]--;
          if (!c[i]) {
            pair<long long, long long> z =
                pair<long long, long long>(siz[i] + 1, i);
            s.erase(z);
            z.first--;
            s.insert(z);
          }
        }
      }
    }
    q[y] = s.size();
  }
  for (long long y = 0; y < m; y++) cout << q[y] << endl;
}
