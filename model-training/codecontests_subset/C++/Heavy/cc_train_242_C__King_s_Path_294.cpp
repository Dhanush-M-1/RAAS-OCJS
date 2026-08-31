#include <bits/stdc++.h>
using namespace std;
int main() {
  int x0, y0, x1, y1;
  scanf("%d%d%d%d", &x0, &y0, &x1, &y1);
  int n;
  scanf("%d", &n);
  unordered_map<long long, bool> av, vis;
  int a, b, c;
  long long tril = 1000000000;
  for (int i = 0; i < n; i++) {
    scanf("%d%d%d", &a, &b, &c);
    for (int j = b; j <= c; j++) {
      av[tril * a + j] = 1;
    }
  }
  unordered_map<long long, int> cnt;
  queue<long long> q;
  q.push(tril * x0 + y0);
  cnt[tril * x0 + y0] = 0;
  vis[tril * x0 + y0] = 1;
  while (!q.empty()) {
    long long f = q.front();
    q.pop();
    long long x, y;
    x = f / tril;
    y = f - x * tril;
    for (int i = x - 1; i <= x + 1; i++) {
      for (int j = y - 1; j <= y + 1; j++) {
        if (av[tril * i + j] && !vis[tril * i + j]) {
          cnt[tril * i + j] = cnt[f] + 1;
          vis[tril * i + j] = 1;
          q.push(tril * i + j);
        }
      }
    }
  }
  if (!vis[x1 * tril + y1])
    printf("-1");
  else
    printf("%d", cnt[x1 * tril + y1]);
}
