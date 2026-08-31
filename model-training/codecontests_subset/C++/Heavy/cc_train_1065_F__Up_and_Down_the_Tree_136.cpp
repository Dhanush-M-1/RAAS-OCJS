#include <bits/stdc++.h>
using namespace std;
inline void read(int &x) {
  char ch;
  bool flag = false;
  for (ch = getchar(); !isdigit(ch); ch = getchar())
    if (ch == '-') flag = true;
  for (x = 0; isdigit(ch); x = x * 10 + ch - '0', ch = getchar())
    ;
  x = flag ? -x : x;
}
inline void write(int x) {
  static const int maxlen = 100;
  static char s[maxlen];
  if (x < 0) {
    putchar('-');
    x = -x;
  }
  if (!x) {
    putchar('0');
    return;
  }
  int len = 0;
  for (; x; x /= 10) s[len++] = x % 10 + '0';
  for (int i = len - 1; i >= 0; --i) putchar(s[i]);
}
const int MAXN = 1e6 + 100;
int n, lim;
int fa[MAXN];
vector<int> son[MAXN];
int deep[MAXN];
int MAX[MAXN];
int siz[MAXN][2];
void get_deep(int x) {
  if (son[x].size() == 0) {
    MAX[x] = x;
    siz[x][1] = 1;
    siz[x][0] = 0;
  } else {
    siz[x][0] = 0;
    siz[x][1] = 0;
    MAX[x] = 0;
  }
  for (int i = 0; i < son[x].size(); i++) {
    int y = son[x][i];
    deep[y] = deep[x] + 1;
    get_deep(y);
    if ((MAX[x] == 0) || (deep[MAX[y]] < deep[MAX[x]])) MAX[x] = MAX[y];
    if (deep[MAX[y]] <= deep[x] + lim) {
      siz[x][1] += siz[y][1];
      siz[x][0] = max(siz[x][0], siz[y][0] - siz[y][1]);
    } else
      siz[x][0] = max(siz[x][0], siz[y][0]);
  }
  siz[x][0] += siz[x][1];
}
int main() {
  read(n);
  read(lim);
  for (int i = 2; i <= n; i++) {
    read(fa[i]);
    son[fa[i]].push_back(i);
  }
  get_deep(1);
  int ans = 0;
  for (int i = 1; i <= n; i++) ans = max(ans, siz[i][0]);
  cout << ans << endl;
  return 0;
}
