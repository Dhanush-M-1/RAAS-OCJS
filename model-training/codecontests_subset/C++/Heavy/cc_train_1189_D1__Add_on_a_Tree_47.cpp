#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
const int O = 1e6;
const int mod = 1e9 + 7;
const int maxn = 1e6 + 5;
const double PI = acos(-1.0);
const double E = 2.718281828459;
const double eps = 1e-8;
struct dd {
  int to, val, next;
} e[maxn];
int head[maxn], cnt = 0;
void add(int u, int v) {
  e[cnt] = {v, 0, head[u]};
  head[u] = cnt++;
}
int main() {
  memset(head, -1, sizeof(head));
  int n;
  scanf("%d", &n);
  int num[maxn];
  memset(num, 0, sizeof(num));
  for (int i = 0; i < n - 1; i++) {
    int u, v;
    scanf("%d%d", &u, &v);
    num[u]++;
    num[v]++;
  }
  bool flag = true;
  for (int i = 1; i <= n; i++) {
    if (num[i] == 2) flag = false;
  }
  flag ? printf("YES\n") : printf("NO\n");
  return 0;
}
