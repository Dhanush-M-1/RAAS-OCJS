#include <bits/stdc++.h>
using namespace std;
int val[300000 + 100], sum[300000 + 100][2], head[300000 + 100];
int f[300000 + 100];
vector<int> V[300000 + 100];
int n, k;
int ans;
int findd(int x) {
  if (f[x] == x) return x;
  int F = f[x];
  f[x] = findd(f[x]);
  val[x] = val[x] ^ val[F];
  return f[x];
}
char s[300000 + 100];
void init() {
  for (int i = 0; i <= max(n, k); i++) f[i] = i;
  for (int i = 1; i <= max(n, k); i++) {
    sum[i][0] = 0;
    sum[i][1] = 1;
  }
  memset(head, -1, sizeof(head));
}
int get(int x) {
  if (head[x] == -1) return min(sum[x][0], sum[x][1]);
  return sum[x][head[x]];
}
void build(int x, int y, int v) {
  int X = findd(x);
  int Y = findd(y);
  if (X != Y) {
    ans -= get(X);
    ans -= get(Y);
    sum[Y][0] += sum[X][v ^ val[x] ^ val[y]];
    sum[Y][1] += sum[X][1 ^ v ^ val[x] ^ val[y]];
    if (head[X] != -1 && head[Y] == -1) {
      head[Y] = v ^ val[x] ^ val[y] ^ head[X];
    }
    val[X] = val[x] ^ val[y] ^ v;
    f[X] = Y;
    ans += get(Y);
  }
}
void work(int x, int v) {
  int X = findd(x);
  ans -= get(X);
  if (head[X] == -1) head[X] = v ^ val[x];
  ans += get(X);
}
int main() {
  int T;
  cin >> n >> k;
  scanf("%s", s + 1);
  for (int i = 1; i <= k; i++) {
    scanf("%d", &T);
    int cpy = T;
    int x;
    while (T--) {
      scanf("%d", &x);
      V[x].push_back(i);
    }
  }
  init();
  for (int i = 1; i <= n; i++) {
    if (V[i].size() == 1) {
      work(V[i][0], 1 ^ (s[i] - '0'));
    } else if (V[i].size() == 2) {
      build(V[i][0], V[i][1], 1 ^ (s[i] - '0'));
    }
    printf("%d\n", ans);
  }
}
