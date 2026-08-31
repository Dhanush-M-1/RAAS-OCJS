#include <bits/stdc++.h>
int main() {
  int n, a, b, c;
  scanf("%d %d %d %d", &n, &a, &b, &c);
  int cnt = 0;
  for (int i = 0; i <= a / 2; i++) {
    for (int j = 0; j <= c; j++) {
      int val = n - i - j * 2;
      if (val >= 0 && val <= b) cnt++;
    }
  }
  printf("%d\n", cnt);
  return 0;
}
