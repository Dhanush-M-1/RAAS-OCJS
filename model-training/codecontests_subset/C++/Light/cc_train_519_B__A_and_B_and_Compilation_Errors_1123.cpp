#include <bits/stdc++.h>
int main() {
  int n, e, a, awwl, one, two;
  a = n = e = awwl = one = two = 0;
  scanf("%d", &n);
  getchar();
  e = n;
  while (e--) {
    scanf("%d", &a);
    getchar();
    awwl += a;
  }
  e = n - 1;
  while (e--) {
    scanf("%d", &a);
    getchar();
    one += a;
  }
  printf("%d\n", awwl - one);
  e = n - 2;
  while (e--) {
    scanf("%d", &a);
    getchar();
    two += a;
  }
  printf("%d\n", one - two);
  return 0;
}
