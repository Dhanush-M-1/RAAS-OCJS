#include <bits/stdc++.h>
using namespace std;
inline int get() {
  char ch = getchar();
  int res = 1;
  while (ch != '?') {
    if (ch == '-') res = -1;
    if (ch == '=') return 0;
    ch = getchar();
  }
  return res;
}
inline int read() {
  char ch = '*';
  int f = 1;
  while (!isdigit(ch = getchar()))
    if (ch == '-') f = -1;
  int num = ch - '0';
  while (isdigit(ch = getchar())) num = num * 10 + ch - '0';
  return num * f;
}
const int N = 1e6 + 10;
int op[N], sum, p, ip, n;
int now;
int main() {
  while (op[++n] = get()) {
    if (op[n] > 0)
      p++;
    else
      ip++;
    now += op[n];
  }
  sum = read();
  if (!ip && p > sum) {
    puts("Impossible");
    return 0;
  }
  if (!p && sum > -ip) {
    puts("Impossible");
    return 0;
  }
  for (register int i = 1; i <= n; i++)
    if (op[i]) {
      while (now < sum && op[i] < sum && op[i] > 0) now++, op[i]++;
      while (now > sum && op[i] > -sum && op[i] < 0) now--, op[i]--;
    }
  if (now != sum) {
    puts("Impossible");
    return 0;
  }
  puts("Possible");
  for (register int i = 1; i <= n; i++)
    if (op[i] != 0) {
      cout << abs(op[i]) << " ";
      if (op[i + 1] > 0)
        cout << "+ ";
      else if (op[i + 1] < 0)
        cout << "- ";
      else
        cout << "= ";
    }
  cout << now << endl;
}
