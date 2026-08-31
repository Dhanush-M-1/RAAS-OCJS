#include <bits/stdc++.h>
using namespace std;
const long long inf = 1ll << 62;
const double eps = 1e-8;
inline void gn(long long& x) {
  int sg = 1;
  char c;
  while (((c = getchar()) < '0' || c > '9') && c != '-')
    ;
  c == '-' ? (sg = -1, x = 0) : (x = c - '0');
  while ((c = getchar()) >= '0' && c <= '9') x = x * 10 + c - '0';
  x *= sg;
}
inline void gn(int& x) {
  long long t;
  gn(t);
  x = t;
}
inline void gn(unsigned long long& x) {
  long long t;
  gn(t);
  x = t;
}
const int maxn = 1e5 + 5;
long long a[maxn], b[maxn];
vector<pair<int, long long> > E[maxn];
void dfs(int u, int pr) {
  for (auto it : E[u]) {
    dfs(it.first, u);
    if (b[it.first] < 0) {
      long long nd = -b[it.first];
      if (it.second > 1.0 * inf / nd) {
        puts("NO");
        exit(0);
      }
      nd *= it.second;
      b[u] -= nd;
      if (b[u] < -inf) {
        puts("NO");
        exit(0);
      }
    } else {
      b[u] += b[it.first];
    }
  }
}
int main() {
  int n;
  gn(n);
  ;
  for (int i = (1); i <= (n); i++) gn(b[i]);
  for (int i = (1); i <= (n); i++) gn(a[i]);
  for (int i = (2); i <= (n); i++) {
    int p, k;
    gn(p);
    gn(k);
    E[p].push_back(make_pair(i, k));
  }
  for (int i = (1); i <= (n); i++) b[i] -= a[i];
  dfs(1, 0);
  if (b[1] >= 0)
    puts("YES");
  else
    puts("NO");
  return 0;
}
