#include <bits/stdc++.h>
using namespace std;
void change(int n, int k, int kk) {
  int a[100], cnt = 0;
  int i;
  while (n) {
    a[cnt++] = n % k;
    n /= k;
  }
  if (cnt == 0) {
    a[cnt++] = 0;
  }
  for (i = 1; i <= kk - cnt; i++) {
    printf(" ");
  }
  for (i = cnt - 1; i >= 0; i--) {
    printf("%d", a[i]);
  }
}
int get_len(int a, int b) {
  int res = 0;
  while (a) {
    a /= b;
    res++;
  }
  if (res == 0) res = 1;
  return res;
}
int main() {
  int i, j, k;
  int n;
  while (scanf("%d", &n) != EOF) {
    for (i = 1; i < n; i++) {
      for (j = 1; j < n; j++) {
        int kk = (n - 1) * j;
        kk = get_len(kk, n);
        if (j > 1) printf(" ");
        change(i * j, n, kk);
      }
      putchar('\n');
    }
  }
  return 0;
}
