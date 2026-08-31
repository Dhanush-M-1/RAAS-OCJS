#include <bits/stdc++.h>
using namespace std;
inline int read() {
  int s = 0;
  bool f = 0;
  char ch = ' ';
  while (!isdigit(ch)) {
    f |= (ch == '-');
    ch = getchar();
  }
  while (isdigit(ch)) {
    s = (s << 3) + (s << 1) + (ch ^ 48);
    ch = getchar();
  }
  return (f) ? (-s) : (s);
}
inline void write(int x) {
  if (x < 0) {
    putchar('-');
    x = -x;
  }
  if (x < 10) {
    putchar(x + '0');
    return;
  }
  write(x / 10);
  putchar((x % 10) + '0');
}
const int N = 1000005;
int n, r, c, b[N], last[N][23];
int jyl, jzx;
string a[N];
inline int ask(int pos, int stp) {
  int i;
  for (i = 21; (~i) && (pos <= n); i--) {
    if ((1 << i) <= stp) {
      pos = last[pos][i] + 1;
      stp -= (1 << i);
    }
  }
  return pos - 1;
}
int main() {
  int i, j, now, tmp;
  n = read();
  r = read();
  c = read();
  b[0] = 0;
  for (i = 1; i <= n; i++) {
    cin >> a[i];
    b[i] = b[i - 1] + a[i].size() + 1;
  }
  for (i = 1; i <= n; i++) {
    now = b[i - 1];
    last[i][0] = upper_bound(b + 1, b + n + 1, now + c + 1) - b;
    last[i][0]--;
  }
  for (i = 1; i <= 21; i++)
    for (j = 1; j <= n; j++)
      last[j][i] = last[min(n, last[j][i - 1] + 1)][i - 1];
  jzx = 0;
  for (i = 1; i <= n; i++) {
    tmp = ask(i, r) - i + 1;
    if (tmp > jzx) {
      jzx = tmp;
      jyl = i;
    }
  }
  now = 1;
  while (now <= r) {
    tmp = 0;
    bool flg = 0;
    while (true) {
      if (tmp + a[jyl].size() + 1 <= c + 1 && jyl <= n) {
        if (flg)
          putchar(' ');
        else
          flg = 1;
        cout << a[jyl];
        tmp += a[jyl].size() + 1;
        jyl++;
      } else
        break;
    }
    now++;
    putchar('\n');
  }
  return 0;
}
