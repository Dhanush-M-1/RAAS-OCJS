#include <bits/stdc++.h>
int main() {
  long long a = 0, b = 0, c = 0;
  int temp, n;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    scanf("%d", &temp);
    a += temp;
  }
  for (int i = 0; i < n - 1; i++) {
    scanf("%d", &temp);
    b += temp;
  }
  for (int i = 0; i < n - 2; i++) {
    scanf("%d", &temp);
    c += temp;
  }
  printf("%lld\n%lld", a - b, b - c);
  return 0;
}
