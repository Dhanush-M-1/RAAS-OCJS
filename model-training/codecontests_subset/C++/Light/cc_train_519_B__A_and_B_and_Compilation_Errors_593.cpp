#include <bits/stdc++.h>
void readInt(int &n) {
  char ch;
  n = 0;
  while (ch = getchar()) {
    if (ch >= '0' && ch <= '9')
      n = n * 10 + ch - 48;
    else
      break;
  }
}
int main() {
  int n, tmp;
  int sum[3] = {0};
  readInt(n);
  for (int i = 0; i < 3; i++) {
    for (int j = 0; j < n - i; j++) {
      readInt(tmp);
      sum[i] ^= tmp;
    }
  }
  printf("%d\n%d\n", sum[0] ^ sum[1], sum[1] ^ sum[2]);
  return 0;
}
