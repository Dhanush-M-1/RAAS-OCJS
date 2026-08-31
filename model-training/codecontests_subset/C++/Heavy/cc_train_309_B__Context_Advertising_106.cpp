#include <bits/stdc++.h>
using namespace std;
char tt[5000010];
int n, R, C, s[1000010], f[20][1000010], len[1000010];
string S[1000010];
int Get(int x) {
  int ans = 0;
  while (x >> 1) {
    ans++;
    x >>= 1;
  }
  return ans;
}
void read(int &x) {
  char ch = getchar();
  int mark = 1;
  for (; ch != '-' && (ch < '0' || ch > '9'); ch = getchar())
    ;
  if (ch == '-') mark = -1, ch = getchar();
  for (x = 0; ch >= '0' && ch <= '9'; ch = getchar()) x = x * 10 + ch - 48;
  x *= mark;
}
void print(int x, bool mk) {
  for (int i = 0; i < S[x].size(); i++) printf("%c", S[x][i]);
  if (mk)
    printf("\n");
  else
    printf(" ");
}
int main() {
  read(n);
  read(R);
  read(C);
  C++;
  for (int i = 1; i <= n; i++) {
    scanf("%s", tt);
    S[i].assign(tt);
    len[i] = S[i].size() + 1;
  }
  for (int i = 1; i <= n; i++) s[i] = s[i - 1] + len[i];
  int end = n + 1, st;
  for (int i = n; i; i--) {
    while (s[end - 1] - s[i - 1] > C) end--;
    f[0][i] = end;
  }
  R = min(n, R);
  int t = Get(R);
  for (int i = 1; i <= t; i++)
    for (int j = 1; j <= n; j++) f[i][j] = f[i - 1][f[i - 1][j]];
  int ans = 0;
  for (int i = 1; i <= n; i++) {
    int u = i, rr = min(R, n - i + 1);
    for (int j = 0; j <= t; j++)
      if ((rr >> j) & 1) u = f[j][u];
    if (u == 0) u = n + 1;
    if (ans < u - i) ans = u - i, st = i;
  }
  if (ans) {
    int t = 0;
    for (int i = st; i <= st + ans - 1; i++) {
      t += len[i];
      if (t > C) t = len[i];
      print(i, (i == st + ans - 1) || (len[i + 1] + t > C));
    }
  }
  return 0;
}
