#include <bits/stdc++.h>
using namespace std;
using vint = vector<long long>;
using pint = pair<long long, long long>;
using vpint = vector<pint>;
template <typename A, typename B>
inline void chmin(A& a, B b) {
  if (a > b) a = b;
}
template <typename A, typename B>
inline void chmax(A& a, B b) {
  if (a < b) a = b;
}
template <class A, class B>
ostream& operator<<(ostream& ost, const pair<A, B>& p) {
  ost << "{" << p.first << "," << p.second << "}";
  return ost;
}
template <class T>
ostream& operator<<(ostream& ost, const vector<T>& v) {
  ost << "{";
  for (long long i = 0; i < v.size(); i++) {
    if (i) ost << ",";
    ost << v[i];
  }
  ost << "}";
  return ost;
}
long long N, M;
vint G[222222];
long long topbit(long long a) { return 63 - __builtin_clzll(a); }
signed main() {
  scanf("%lld%lld", &N, &M);
  vint A(N);
  for (long long i = 0; i < (N); i++) scanf("%lld", &A[i]);
  for (long long i = 0; i < (M); i++) {
    long long a, b;
    scanf("%lld%lld", &a, &b);
    a--;
    b--;
    G[a].push_back(b);
  }
  vint ord;
  vint deg(N);
  for (long long i = 0; i < (N); i++)
    for (auto u : G[i]) deg[u]++;
  for (long long i = 0; i < (N); i++)
    if (deg[i] == 0) ord.push_back(i);
  for (long long i = 0; i < (N); i++) {
    long long v = ord[i];
    for (auto u : G[v]) {
      if (--deg[u] == 0) ord.push_back(u);
    }
  }
  reverse((ord).begin(), (ord).end());
  vint q(N);
  for (auto v : ord) {
    set<long long> s;
    for (auto u : G[v]) s.insert(q[u]);
    q[v] = 0;
    while (s.find(q[v]) != s.end()) q[v]++;
  }
  vint x(N);
  for (long long i = 0; i < (N); i++) x[q[i]] ^= A[i];
  long long w = -1;
  for (long long i = 0; i < (N); i++)
    if (x[i]) w = i;
  if (w == -1) {
    puts("LOSE");
    return 0;
  }
  for (long long i = 0; i < (N); i++) {
    if (q[i] != w) continue;
    if (!(A[i] >> topbit(x[w]) & 1)) continue;
    A[i] ^= x[w];
    for (auto u : G[i]) {
      A[u] ^= x[q[u]];
      x[q[u]] = 0;
    }
    break;
  }
  puts("WIN");
  for (long long i = 0; i < (N); i++) {
    if (i) printf(" ");
    printf("%lld", A[i]);
  }
  puts("");
  return 0;
}
