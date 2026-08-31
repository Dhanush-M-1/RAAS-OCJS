#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
int T;
int n, L;
long long l, r;
vector<int> v = {1, 2, 1};
long long cyc(int x) {
  if (x == n - 1) return 3;
  long long res = 2 * (n - x);
  return res;
}
void printcyc(int nr, long long start, int len) {
  if (nr == n - 1) {
    int step = 1;
    int x = n - 1;
    while (len > 0) {
      if (start > 0)
        start--;
      else {
        printf("%d ", x);
        len--;
      }
      if (step == 1) x = n;
      if (step == 2) x = 1;
      step++;
    }
    return;
  }
  int loops = start / 2;
  int c = nr + 1 + loops;
  int x = c;
  if (start % 2 == 0) x = nr;
  while (len > 0) {
    printf("%d ", x);
    len--;
    if (x != nr) {
      if (c == n) {
        printcyc(nr + 1, 0, len);
        break;
      } else {
        c++;
        x = nr;
      }
    } else {
      x = c;
    }
  }
}
void solve() {
  long long t = 1;
  for (int i = 1; i <= n - 1; i++) {
    if (t + cyc(i) < l)
      t += cyc(i);
    else {
      printcyc(i, l - t, L);
      break;
    }
  }
  printf("\n");
}
int main() {
  scanf("%d", &T);
  for (int test = 1; test <= T; test++) {
    scanf("%d%lld%lld", &n, &l, &r);
    if (n == 2) {
      for (int i = l - 1; i < r; i++) printf("%d ", v[i]);
      printf("\n");
      continue;
    }
    L = r - l + 1;
    solve();
  }
}
