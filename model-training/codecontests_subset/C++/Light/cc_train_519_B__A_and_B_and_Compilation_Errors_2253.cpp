#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a = 0, b = 0, c = 0, x;
  scanf("%d", &n);
  for (int i = 0; i < n; ++i) {
    scanf("%d", &x);
    a ^= x;
  }
  for (int i = 0; i < n - 1; ++i) {
    scanf("%d", &x);
    b ^= x;
  }
  for (int i = 0; i < n - 2; ++i) {
    scanf("%d", &x);
    c ^= x;
  }
  printf("%d\n%d", a ^ b, b ^ c);
}
