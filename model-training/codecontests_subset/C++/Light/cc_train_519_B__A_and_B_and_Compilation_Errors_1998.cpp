#include <bits/stdc++.h>
using namespace std;
int main() {
  int n = 0, x = 0;
  long long a = 0, b = 0, c = 0;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    scanf("%d", &x);
    a += x;
  }
  for (int i = 0; i < n - 1; i++) {
    scanf("%d", &x);
    b += x;
  }
  for (int i = 0; i < n - 2; i++) {
    scanf("%d", &x);
    c += x;
  }
  printf("%I64d\n%I64d\n", a - b, b - c);
  return 0;
}
