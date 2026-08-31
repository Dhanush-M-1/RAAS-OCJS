#include <bits/stdc++.h>
using namespace std;
int n;
long long cl[202020];
long long T[202020];
int chk[202020];
int ans[202020];
void m_Tree(int x, int t) {
  for (int i = x; i <= n; i += i & (-i)) {
    T[i] += t;
  }
}
long long g_Tree(int x) {
  long long ret = 0;
  for (int i = x; i > 0; i -= i & (-i)) ret += T[i];
  return ret;
}
int BS(int s, int e, long long t) {
  if (s == e) return s;
  int m = (s + e) / 2 + 1;
  if (t >= g_Tree(m - 1)) return BS(m, e, t);
  return BS(s, m - 1, t);
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%lld", cl + i), m_Tree(i, i);
  for (int i = n; i > 0; i--) {
    ans[i] = BS(1, n, cl[i]);
    m_Tree(ans[i], -ans[i]);
    chk[ans[i]] = 1;
  }
  for (int i = 1; i <= n; i++) printf("%d ", ans[i]);
}
