#include <bits/stdc++.h>
using namespace std;
int p[1000], r[1000], col[1000];
int getp(int v) {
  if (p[v] == v) return v;
  int pr = getp(p[v]);
  col[v] ^= col[p[v]];
  p[v] = pr;
  return p[v];
}
void join(int a, int b, int d) {
  if (r[a] > r[b])
    swap(a, b);
  else if (r[a] == r[b])
    ++r[b];
  p[a] = b;
  col[a] = 1 ^ d;
}
int main() {
  int n, m, Q;
  scanf("%d%d%d", &n, &m, &Q);
  vector<array<int, 4>> v(m);
  for (int i = 0; i < m; ++i) {
    scanf("%d%d%d", &v[i][1], &v[i][2], &v[i][0]);
    --v[i][1];
    --v[i][2];
    v[i][3] = i + 1;
  }
  sort(v.rbegin(), v.rend());
  for (int test = 0; test < Q; ++test) {
    int L, R;
    scanf("%d%d", &L, &R);
    memset(r, 0, sizeof(r));
    memset(col, 0, sizeof(col));
    for (int i = 0; i < n; ++i) p[i] = i;
    int ans = -1;
    for (int i = 0; i < v.size(); ++i)
      if (v[i][3] >= L && v[i][3] <= R) {
        int a = getp(v[i][1]), b = getp(v[i][2]);
        if (a != b) {
          join(a, b, col[v[i][1]] ^ col[v[i][2]]);
        } else {
          if (col[v[i][1]] == col[v[i][2]]) {
            ans = v[i][0];
            break;
          }
        }
      }
    printf("%d\n", ans);
  }
  return 0;
}
