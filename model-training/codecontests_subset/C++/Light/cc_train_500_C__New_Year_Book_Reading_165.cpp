#include <bits/stdc++.h>
using namespace std;
const int maxn = 500 + 10;
const int maxm = 1000 + 10;
int w[maxn];
int b[maxm];
int vis[maxn];
stack<int> book;
stack<int> up;
int main() {
  int n, m;
  memset(vis, 0, sizeof(vis));
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; i++) scanf("%d", &w[i]);
  for (int i = 0; i < m; i++) {
    scanf("%d", &b[i]);
    if (!vis[b[i]]) {
      up.push(b[i]);
      vis[b[i]] = 1;
    }
  }
  while (!up.empty()) {
    book.push(up.top());
    up.pop();
  }
  int res = 0;
  for (int i = 0; i < m; i++) {
    int cur = book.top();
    book.pop();
    while (cur != b[i]) {
      res += w[cur];
      up.push(cur);
      cur = book.top();
      book.pop();
    }
    while (!up.empty()) {
      book.push(up.top());
      up.pop();
    }
    book.push(cur);
  }
  printf("%d\n", res);
  return 0;
}
