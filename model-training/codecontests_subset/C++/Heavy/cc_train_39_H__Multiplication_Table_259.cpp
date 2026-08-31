#include <bits/stdc++.h>
using namespace std;
int k;
int read() {
  static int res;
  static char op;
  do op = getchar();
  while (op > '9' || op < '0');
  for (res = 0; op >= '0' && op <= '9'; op = getchar())
    res = res * 10 + (op ^ 48);
  return res;
}
int calc(int x) {
  static int sta[11], top, res;
  for (top = 0; x; x /= k) sta[++top] = x % k;
  for (res = 0; top; --top) res = res * 10 + sta[top];
  return res;
}
signed main(int argc, char **argv) {
  k = read();
  for (int i = 1; i < k; ++i) printf("%d ", i);
  for (int i = 2, j; i < k; ++i) {
    printf("\n%d", i);
    for (j = 2; j < k; ++j) printf(" %d", calc(i * j));
  }
  return 0;
}
