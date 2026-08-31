#include <bits/stdc++.h>
using namespace std;
const int N = 204;
int t, n;
string s[N];
void solve(char z1, char z2, char y1, char y2) {
  if (z1 == '0' && z2 == '0') {
    if (y1 == '1' && y2 == '1')
      puts("0");
    else if (y1 == '0' && y2 == '0') {
      printf("2\n%d %d\n%d %d\n", n, n - 1, n - 1, n);
    } else if (y1 == '1' && y2 == '0') {
      printf("1\n%d %d\n", n - 1, n);
    } else {
      printf("1\n%d %d\n", n, n - 1);
    }
  }
  if (z1 == '1' && z2 == '1') {
    if (y1 == '0' && y2 == '0')
      puts("0");
    else if (y1 == '1' && y2 == '1') {
      printf("2\n%d %d\n%d %d\n", n, n - 1, n - 1, n);
    } else if (y1 == '0' && y2 == '1') {
      printf("1\n%d %d\n", n - 1, n);
    } else {
      printf("1\n%d %d\n", n, n - 1);
    }
  }
}
int main() {
  scanf("%d", &t);
  while (t--) {
    scanf("%d", &n);
    for (int i = 0; i <= n - 1; ++i) cin >> s[i];
    char z1 = s[1][0], z2 = s[0][1], y1 = s[n - 1][n - 2], y2 = s[n - 2][n - 1];
    if (z1 == z2)
      solve(z1, z2, y1, y2);
    else if (z1 == '1' && z2 == '0') {
      if (y1 == '1' && y2 == '0')
        printf("2\n1 2\n%d %d\n", n, n - 1);
      else if (y1 == '1' && y2 == '1')
        printf("1\n2 1\n");
      else if (y1 == '0' && y2 == '1')
        printf("2\n1 2\n%d %d\n", n - 1, n);
      else
        printf("1\n1 2\n");
    } else {
      if (y1 == '1' && y2 == '0')
        printf("2\n1 2\n%d %d\n", n - 1, n);
      else if (y1 == '1' && y2 == '1')
        printf("1\n1 2\n");
      else if (y1 == '0' && y2 == '1')
        printf("2\n1 2\n%d %d\n", n, n - 1);
      else
        printf("1\n2 1\n");
    }
  }
}
