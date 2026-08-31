#include <bits/stdc++.h>
using namespace std;
long long a[10];
bool calc[20][10], f[100][100];
int num, c[100];
int attemp(int pos, int cary) {
  if (calc[pos][cary]) return f[pos][cary];
  calc[pos][cary] = true;
  if (pos > num) {
    f[pos][cary] = (cary == 0);
    return f[pos][cary];
  }
  f[pos][cary] = false;
  for (int i = (0), _b = (6); i <= _b; i++)
    for (int j = (0), _b = (6 - i); j <= _b; j++)
      if ((i * 4 + j * 7 + cary) % 10 == c[pos]) {
        f[pos][cary] |= attemp(pos + 1, (i * 4 + j * 7 + cary) / 10);
      }
  return f[pos][cary];
}
void add(long long &a, int pos, int digit) {
  long long t = digit;
  for (int i = (2), _b = (pos); i <= _b; i++) t *= 10;
  a += t;
}
void trace(int pos, int cary) {
  if (pos > num) return;
  for (int i = (0), _b = (6); i <= _b; i++)
    for (int j = (0), _b = (6 - i); j <= _b; j++)
      if ((i * 4 + j * 7 + cary) % 10 == c[pos])
        if (attemp(pos + 1, (i * 4 + j * 7 + cary) / 10)) {
          for (int k = (1), _b = (i); k <= _b; k++) add(a[k], pos, 4);
          for (int k = (i + 1), _b = (i + j); k <= _b; k++) add(a[k], pos, 7);
          trace(pos + 1, (i * 4 + j * 7 + cary) / 10);
          return;
        }
}
int main() {
  int ntest;
  cin >> ntest;
  while (ntest--) {
    long long n;
    cin >> n;
    num = 0;
    do {
      c[++num] = n % 10;
      n /= 10;
    } while (n);
    memset(calc, false, sizeof(calc));
    int res = attemp(1, 0);
    if (!res)
      cout << -1 << endl;
    else {
      memset(a, 0, sizeof(a));
      trace(1, 0);
      for (int i = (1), _b = (6); i <= _b; i++) cout << a[i] << " ";
      cout << endl;
    }
  }
  return 0;
}
