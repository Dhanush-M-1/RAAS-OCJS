#include <bits/stdc++.h>
using namespace std;
long long rdtsc() {
  long long tmp;
  asm("rdtsc" : "=A"(tmp));
  return tmp;
}
inline int myrand() { return abs((rand() << 15) ^ rand()); }
inline int rnd(int x) { return myrand() % x; }
const int maxs = (int)6e6 + 10;
char tmp[maxs];
const int maxn = (int)1e6 + 10;
char* words[maxn];
int a[maxn];
int f[maxn];
int sum[maxn + 1];
int value[2][maxn];
void jump(int n, int r, int id) {
  if (r > 1) {
    jump(n, r / 2, id ^ 1);
    for (int i = 0; i < n; ++i) {
      value[id][i] = value[id ^ 1][i];
      if (value[id][i] < n) value[id][i] = value[id ^ 1][value[id][i]];
    }
  } else {
    for (int i = 0; i < n; ++i) value[id][i] = i;
  }
  if (r & 1) {
    for (int i = 0; i < n; ++i) {
      if (value[id][i] < n) value[id][i] = f[value[id][i]];
    }
  }
}
bool solve() {
  int n, r, c;
  if (scanf("%d%d%d ", &n, &r, &c) < 3) return 0;
  gets(tmp);
  int cnt = 0;
  for (int pos = 0, len = strlen(tmp); pos < len;) {
    while (pos < len && isspace(tmp[pos])) ++pos;
    if (pos == len) break;
    words[cnt++] = tmp + pos;
    int& cur = a[cnt - 1];
    cur = 1;
    while (pos < len && !isspace(tmp[pos])) ++pos, ++cur;
  }
  assert(cnt == n);
  sum[0] = 0;
  for (int i = 0; i < n; ++i) sum[i + 1] = sum[i] + a[i];
  for (int i = 0; i < n; ++i) {
    int l = i, r = n + 1;
    while (l + 1 < r) {
      int m = (l + r) / 2;
      if (sum[m] - sum[i] <= c + 1)
        l = m;
      else
        r = m;
    }
    f[i] = l;
  }
  jump(n, r, 0);
  int where = 0;
  for (int i = 1; i < n; ++i) {
    if ((value[0][i] - i) > (value[0][where] - where)) where = i;
  }
  for (int i = 0; i < r && where < n; ++i, where = f[where]) {
    if (where == f[where]) break;
    for (int j = where; j < f[where]; ++j) {
      for (int k = 0; k < a[j] - 1; ++k) printf("%c", words[j][k]);
      if (j == f[where] - 1)
        printf("\n");
      else
        printf(" ");
    }
  }
  return 1;
}
int main() {
  srand(rdtsc());
  while (1) {
    if (!solve()) break;
    exit(0);
  }
  return 0;
}
