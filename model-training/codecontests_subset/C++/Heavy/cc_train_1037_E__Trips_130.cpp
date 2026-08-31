#include <bits/stdc++.h>
using namespace std;
template <class T1, class T2>
inline void upd1(T1& a, const T2& b) {
  a = a < b ? a : b;
}
template <class T1, class T2>
inline void upd2(T1& a, const T2& b) {
  a = a > b ? a : b;
}
template <class T>
inline bool equ(const T& a, const T& b) {
  return !memcmp(&a, &b, sizeof a);
}
long long gcd(long long a, long long b) { return b ? gcd(b, a % b) : a; }
struct ano {
  operator long long() {
    long long x = 0, y = 0, c = getchar();
    while (c < 48) y = c == 45, c = getchar();
    while (c > 47) x = x * 10 + c - 48, c = getchar();
    return y ? -x : x;
  }
} buf;
const int N = 2e5 + 5;
set<int> t[N];
int d[N], f[N];
int main() {
  int n = buf, m = buf, k = buf;
  vector<array<int, 2>> e;
  set<array<int, 2>> c;
  for (int i = 0; i < m; ++i) {
    int u = buf, v = buf;
    if (u > v) swap(u, v);
    c.insert({u, v});
    e.push_back({u, v});
    t[u].insert(v);
    t[v].insert(u);
    ++d[u];
    ++d[v];
  }
  queue<int> q;
  for (int i = 1; i <= n; ++i)
    if (d[i] < k) q.push(i);
  int s = n;
  for (int i = m - 1; ~i; --i) {
    while (q.size()) {
      int u = q.front();
      q.pop();
      for (int v : t[u]) {
        c.erase({min(u, v), max(u, v)});
        t[v].erase(u);
        if (d[v]-- == k) q.push(v);
      }
      --s;
    }
    f[i] = s;
    if (c.count(e[i])) {
      int u = e[i][0], v = e[i][1];
      t[u].erase(v);
      t[v].erase(u);
      if (d[u]-- == k) q.push(u);
      if (d[v]-- == k) q.push(v);
    }
  }
  for (int i = 0; i < m; ++i) printf("%d\n", f[i]);
}
