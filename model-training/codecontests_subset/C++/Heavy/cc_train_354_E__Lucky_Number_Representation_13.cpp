#include <bits/stdc++.h>
using namespace std;
bool succ;
int dig[25];
long long sol[6];
stack<int> a, b, c;
void dfs(int x, int r) {
  if (x < 0) {
    if (r == 0)
      succ = 1;
    else
      return;
    memset(sol, 0, sizeof(sol));
    while (!a.empty()) {
      int i = 0, u;
      u = a.top();
      a.pop();
      while (u--) {
        sol[i] = sol[i] * 10 + 4;
        i++;
      }
      u = b.top();
      b.pop();
      while (u--) {
        sol[i] = sol[i] * 10 + 7;
        i++;
      }
      u = c.top();
      c.pop();
      while (u--) {
        sol[i] = sol[i] * 10;
        i++;
      }
    }
    for (int i = 0; i < 6; i++)
      printf("%I64d%c", sol[i], (i == 5) ? '\n' : ' ');
    return;
  }
  for (int i = 0; i <= 6 && !succ; i++) {
    for (int j = 0; j <= 6 - i && !succ; j++) {
      int tmp = r + 4 * i + 7 * j;
      if (tmp % 10 == dig[x]) {
        a.push(i);
        b.push(j);
        c.push(6 - i - j);
        dfs(x - 1, tmp / 10);
        if (succ) break;
        a.pop();
        b.pop();
        c.pop();
      }
    }
  }
}
void gao(long long x) {
  int cnt = 0;
  do {
    dig[cnt++] = x % 10;
    x /= 10;
  } while (x);
  reverse(dig, dig + cnt);
  dfs(cnt - 1, 0);
}
int main() {
  int T;
  long long x;
  scanf("%d", &T);
  while (T--) {
    scanf("%I64d", &x);
    while (!a.empty()) a.pop();
    while (!b.empty()) b.pop();
    while (!c.empty()) c.pop();
    succ = 0;
    gao(x);
    if (!succ) printf("-1\n");
  }
  return 0;
}
