#include <bits/stdc++.h>
using namespace std;
template <class T>
bool Maximize(T &v, T nv) {
  if (nv > v) return v = nv, 1;
  return 0;
}
template <class T>
bool Minimize(T &v, T nv) {
  if (nv < v) return v = nv, 1;
  return 0;
}
template <class T>
T Mod(T &v, T mod) {
  return v = (v % mod + mod) % mod;
}
const long long INFLL = numeric_limits<long long>::max();
const long INF = numeric_limits<long>::max(), N = 501, M = 1001;
const long di[4][2] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
long w[N], a[M];
bool u[N];
bool cmp(long a, long b) { return w[a] < w[b]; }
void solve() {
  long n, m;
  scanf("%ld %ld", &n, &m);
  for (long i = 1; i <= n; ++i) scanf("%ld", w + i);
  deque<long> s;
  for (long i = 0; i < m; ++i) {
    scanf("%ld", a + i);
    if (!u[a[i]]) s.push_back(a[i]), u[a[i]] = 1;
    ;
  }
  vector<long> ss;
  for (long i = 1; i <= n; ++i) {
    if (!u[i]) ss.push_back(i);
  }
  sort((ss).begin(), (ss).end(), cmp);
  s.insert(s.end(), (ss).begin(), (ss).end());
  long ans = 0;
  for (long i = 0; i < m; ++i) {
    long j;
    for (j = 0; s[j] != a[i]; ++j) {
      ans += w[s[j]];
    }
    s.erase(s.begin() + j);
    s.push_front(a[i]);
  }
  printf("%ld\n", ans);
}
void init() {}
int main() {
  init();
  solve();
  return 0;
}
