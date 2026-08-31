#include <bits/stdc++.h>
using namespace std;
const int MAXN = 600005, INF = 1000000000;
int N, K, a[MAXN];
vector<int> V[MAXN];
char S[MAXN];
int fa[MAXN], val[MAXN], ans;
int get(int x) {
  if (fa[x] != x) fa[x] = get(fa[x]);
  return fa[x];
}
void merge(int x, int y) {
  x = get(x), y = get(y);
  if (x != y) fa[x] = y, val[y] += val[x];
}
inline int va(int x) { return min(val[get(x)], val[get(x + K)]); }
int main() {
  scanf("%d%d%s", &N, &K, S + 1);
  int i, j;
  for (i = 1; i <= K; ++i) {
    int c, x;
    scanf("%d", &c);
    while (c--) scanf("%d", &x), V[x].push_back(i);
  }
  for (i = 1; i <= K * 2; ++i) fa[i] = i, val[i] = i > K;
  fa[K * 2 + 1] = K * 2 + 1, val[K * 2 + 1] = INF;
  for (i = 1; i <= N; ++i) {
    if (V[i].size() == 1) {
      int x = V[i][0] + (S[i] == '1') * K;
      ans -= va(V[i][0]), merge(x, K * 2 + 1), ans += va(V[i][0]);
    } else if (V[i].size() == 2) {
      int x = V[i][0], y = V[i][1];
      if (S[i] == '0') {
        if (get(x) != get(y + K))
          ans -= va(x) + va(y), merge(x, y + K), merge(x + K, y), ans += va(x);
      } else {
        if (get(x) != get(y))
          ans -= va(x) + va(y), merge(x, y), merge(x + K, y + K), ans += va(x);
      }
    }
    printf("%d\n", ans);
  }
  return 0;
}
