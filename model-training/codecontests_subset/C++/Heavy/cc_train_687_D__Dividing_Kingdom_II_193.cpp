#include <bits/stdc++.h>
using namespace std;
long long mul(long long a, long long b) { return (a * b) % (100000007); }
long long add(long long a, long long b) { return (a + b) % (100000007); }
long long sub(long long a, long long b) {
  return (a - b + llabs(a - b) / (100000007) * (100000007) + (100000007)) %
         (100000007);
}
long long gcd(long long a, long long b) {
  if (!b) return a;
  return gcd(b, a % b);
}
void upd(long long &a, long long b) {
  a = (a % (100000007) + b % (100000007)) % (100000007);
}
int read() {
  int x = 0, f = 1;
  char ch = getchar();
  while (!isdigit(ch)) {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (isdigit(ch)) {
    x = x * 10 + ch - '0';
    ch = getchar();
  }
  return x * f;
}
class bingchaji {
 public:
  int father[(2000 + 10)], n;
  void mem(int _n) {
    n = _n;
    for (int i = 1; i <= n; i++) father[i] = i;
  }
  int getfather(int x) {
    if (father[x] == x) return x;
    return father[x] = getfather(father[x]);
  }
  void unite(int x, int y) {
    father[x] = getfather(father[x]);
    father[y] = getfather(father[y]);
    father[father[x]] = father[father[y]];
  }
  bool same(int x, int y) { return getfather(x) == getfather(y); }
} S;
int n, m, q;
vector<pair<int, pair<int, pair<int, int>>>> e;
int main() {
  while (cin >> n >> m >> q) {
    for (int i = 1; i <= m; i++) {
      int u, v, w;
      cin >> u >> v >> w;
      e.push_back(make_pair(w, make_pair(u, make_pair(v, i))));
    }
    sort((e).begin(), (e).end());
    reverse((e).begin(), (e).end());
    for (int i = 0; i < q; i++) {
      bool b = 0;
      int l, r;
      cin >> l >> r;
      S.mem(2 * n);
      for (int i = 0; i < m; i++)
        if (l <= e[i].second.second.second && e[i].second.second.second <= r) {
          int u = e[i].second.first, v = e[i].second.second.first;
          if (S.same(u, v)) {
            b = 1;
            cout << e[i].first << endl;
            break;
          } else {
            S.unite(u, v + n);
            S.unite(u + n, v);
          }
        }
      if (!b) puts("-1");
    }
  }
  return 0;
}
