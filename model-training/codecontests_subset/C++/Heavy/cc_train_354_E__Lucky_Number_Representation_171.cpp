#include <bits/stdc++.h>
using namespace std;
int a[100][4];
int all;
unsigned long long M;
int d[100], np;
unsigned long long te[100];
void prework() {
  all = 0;
  for (int i = 0; i <= 6; i++)
    for (int j = 0; j <= 6 - i; j++) {
      int k = 6 - i - j;
      a[++all][0] = j * 4 + k * 7;
      a[all][1] = i;
      a[all][2] = i + j;
      a[all][3] = i + j + k;
    }
  te[0] = 1;
  for (int i = 1; i <= 18; i++) te[i] = te[i - 1] * 10;
}
bool check(unsigned long long a, unsigned long long b, int p) {
  int aa = a / te[p - 1] % 10;
  int bb = b / te[p - 1] % 10;
  return aa == bb;
}
bool work(unsigned long long mul, unsigned long long now, int p) {
  if (mul == now) return true;
  for (int i = 1; i <= all; i++) {
    if (mul - now < a[i][0] * te[p]) continue;
    unsigned long long ne = now + a[i][0] * te[p];
    if (!check(mul, ne, p + 1)) continue;
    d[p] = i;
    np = p;
    if (work(mul, ne, p + 1)) return true;
  }
  return false;
}
int dig[6][20];
void output() {
  for (int i = 0; i <= np; i++) {
    for (int j = 0; j < a[d[i]][1]; j++) dig[j][i] = 0;
    for (int j = a[d[i]][1]; j < a[d[i]][2]; j++) dig[j][i] = 4;
    for (int j = a[d[i]][2]; j < a[d[i]][3]; j++) dig[j][i] = 7;
  }
  for (int i = 0; i < 6; i++) {
    unsigned long long now = 0;
    for (int j = 0; j <= np; j++) now += te[j] * dig[i][j];
    cout << now << " ";
  }
  cout << endl;
}
int main() {
  prework();
  int T;
  cin >> T;
  unsigned long long N;
  while (T--) {
    memset(dig, 0, sizeof(dig));
    cin >> N;
    if (work(N, 0, 0))
      output();
    else
      cout << -1 << endl;
  }
}
