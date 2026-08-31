#include <bits/stdc++.h>
using namespace std;
const int MAXN = 5200;
int n, arr[MAXN][MAXN];
int gcd(int a, int b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
int hexToDec(char c) {
  int dec = 0;
  if ('0' <= c && '9' >= c)
    dec = (int)c - '0';
  else if ('A' <= c && 'F' >= c)
    dec = (int)c - 'A' + 10;
  return dec;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    char s[MAXN / 4 + 1];
    scanf("%s", s);
    for (int j = 0; j < n / 4; j++) {
      int dec = hexToDec(s[j]);
      for (int k = 0; k < 4; k++) {
        if (dec & (1 << k)) arr[i][4 * j + 3 - k] = 1;
      }
    }
  }
  int x = n;
  for (int i = 0; i < n; i++) {
    int len = 1;
    int j = 0, ptr = 0;
    while (ptr < n) {
      if (arr[i][ptr] == arr[i][j])
        ptr++;
      else {
        len = ptr - j;
        x = gcd(x, len);
        j = ptr;
      }
    }
  }
  for (int j = 0; j < n; j++) {
    int len = 1;
    int i = 0, ptr = 0;
    while (ptr < n) {
      if (arr[ptr][j] == arr[i][j])
        ptr++;
      else {
        len = ptr - i;
        x = gcd(x, len);
        i = ptr;
      }
    }
  }
  printf("%d\n", x);
}
