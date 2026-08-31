#include <bits/stdc++.h>
using namespace std;
struct fenwick {
  long long N;
  vector<long long> Bit;
  fenwick(long long n = 1e5) {
    N = n;
    n += 5;
    Bit.resize(n, 0);
  }
  void update(long long id, long long val) {
    while (id <= N) {
      Bit[id] += val;
      id += id & -id;
    }
  }
  long long query(long long id) {
    long long res = 0;
    while (id) {
      res += Bit[id];
      id -= id & -id;
    }
    return res;
  }
  long long query(long long l, long long r) { return query(r) - query(l - 1); }
};
signed main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  long long n;
  cin >> n;
  vector<pair<long long, long long> > a(n);
  for (long long i = (0); i < (n); i++) cin >> a[i].first;
  for (long long i = (0); i < (n); i++) cin >> a[i].second;
  sort(a.begin(), a.end());
  map<long long, long long> cmp;
  for (long long i = (0); i < (n); i++) cmp[a[i].second];
  long long c = 1;
  for (auto &i : cmp) i.second = c++;
  for (long long i = (0); i < (n); i++) a[i].second = cmp[a[i].second];
  fenwick f1(c + 100), f2(c + 100);
  long long ans = 0;
  for (long long i = (n - 1); i > (-1); i--) {
    ans += f1.query(a[i].second, c + 5);
    ans -= f2.query(a[i].second, c + 5) * a[i].first;
    f1.update(a[i].second, a[i].first);
    f2.update(a[i].second, 1);
  }
  cout << ans;
}
