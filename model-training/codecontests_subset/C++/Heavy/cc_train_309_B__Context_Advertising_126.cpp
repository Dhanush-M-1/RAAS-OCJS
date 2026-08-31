#include <bits/stdc++.h>
using namespace std;
int f[1000001][21];
int g[1000001];
int len[1000001];
int sl[1000001];
int st[1000001];
string a[1000001];
char s1[1000001];
int n, r, c;
char ch;
void print(int k) {
  for (int i = 0; i < len[k]; i++) printf("%c", a[k][i]);
  return;
}
int main() {
  scanf("%d%d%d", &n, &r, &c);
  scanf("%c", &ch);
  int z = 1;
  while (z <= n) {
    ch = getchar();
    if (ch == ' ')
      z++;
    else if (ch == '\n')
      break;
    else
      a[z] += ch;
  }
  for (int i = 1; i <= n; i++) len[i] = a[i].length();
  int l = 0;
  int l1 = 0;
  int ans = 1;
  for (int i = 1; i <= n; i++) {
    l1 += len[i] + 1;
    while (l1 - 1 > c) {
      l++;
      l1 -= len[l] + 1;
    }
    f[i][0] = l;
  }
  for (int i = 1; i <= n; i++) sl[i] = sl[i - 1] + (f[i][0] != i);
  for (int j = 1; j <= 20; j++)
    for (int i = 1; i <= n; i++) f[i][j] = f[f[i][j - 1]][j - 1];
  for (int i = 1; i <= n; i++) {
    g[i] = i;
    for (int j = 19; j >= 0; j--)
      if ((1 << j) & r) g[i] = f[g[i]][j];
  }
  for (int i = 1; i <= n; i++)
    if (sl[i] - sl[g[i] - 1] > sl[ans] - sl[g[ans] - 1]) ans = i;
  z = 0;
  int temp = ans;
  for (int i = 1; i <= r; i++) {
    st[++z] = temp;
    if (temp == g[ans]) st[z]++;
    temp = f[temp][0];
  }
  for (int i = g[ans] + 1; i <= ans; i++) {
    print(i);
    if (i == st[z])
      printf("\n"), z--;
    else
      printf(" ");
    while (z > 0 && st[z] <= i) z--;
  }
  return 0;
}
