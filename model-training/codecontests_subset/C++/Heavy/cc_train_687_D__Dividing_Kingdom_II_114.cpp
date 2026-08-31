#include <bits/stdc++.h>
using namespace std;
struct str {
  int a, b, len;
} edge[1010 * 1010], sing[1010 * 1010];
vector<str> Edge[501000 << 2];
int n, m, Q;
int top, ans;
int re[1010], fa[1010];
bool cmp(const str &a, const str &b) { return (a.len > b.len); }
int find(int a) {
  if (a == fa[a]) return a;
  int f = fa[a];
  fa[a] = find(f);
  re[a] ^= re[f];
  return fa[a];
}
void build(int u, int L, int R) {
  int n = 0;
  for (int i = L; i <= R; i++) sing[++n] = edge[i];
  sort(sing + 1, sing + n + 1, cmp);
  for (int i = 1; i <= n; i++) {
    int a = sing[i].a, b = sing[i].b;
    if (find(a) != find(b)) {
      re[fa[a]] = re[a] ^ re[b] ^ 1;
      fa[fa[a]] = fa[b];
      Edge[u].push_back(sing[i]);
    } else if (re[a] == re[b]) {
      Edge[u].push_back(sing[i]);
      break;
    }
  }
  for (int i = 1; i <= n; i++) {
    int a = sing[i].a, b = sing[i].b;
    re[a] = 0;
    re[b] = 0;
    fa[a] = a;
    fa[b] = b;
  }
  if (L < R) {
    build((u << 1), L, ((L + R) >> 1));
    build((u << 1 | 1), (((L + R) >> 1) + 1), R);
  }
  return;
}
void proc(int u, int L, int R, int l, int r) {
  if (L == l && R == r) {
    for (int i = 0; i < (int)Edge[u].size(); i++) sing[++top] = Edge[u][i];
    return;
  }
  if (r < (((L + R) >> 1) + 1))
    proc((u << 1), L, ((L + R) >> 1), l, r);
  else if (l > ((L + R) >> 1))
    proc((u << 1 | 1), (((L + R) >> 1) + 1), R, l, r);
  else {
    proc((u << 1), L, ((L + R) >> 1), l, ((L + R) >> 1));
    proc((u << 1 | 1), (((L + R) >> 1) + 1), R, (((L + R) >> 1) + 1), r);
  }
  return;
}
int main() {
  scanf("%d %d %d", &n, &m, &Q);
  for (int i = 1; i <= m; i++) {
    scanf("%d %d %d", &edge[i].a, &edge[i].b, &edge[i].len);
  }
  for (int i = 1; i <= n; i++) fa[i] = i;
  build(1, 1, m);
  for (; Q; Q--) {
    int l, r;
    for (int i = 1; i <= n; i++) re[i] = 0, fa[i] = i;
    scanf("%d %d", &l, &r);
    top = 0;
    proc(1, 1, m, l, r);
    sort(sing + 1, sing + top + 1, cmp);
    ans = -1;
    for (int i = 1; i <= top; i++) {
      int a = sing[i].a, b = sing[i].b;
      if (find(a) != find(b)) {
        re[fa[a]] = re[a] ^ re[b] ^ 1;
        fa[fa[a]] = fa[b];
      } else if (re[a] == re[b]) {
        ans = sing[i].len;
        break;
      }
    }
    printf("%d\n", ans);
  }
  return 0;
}
