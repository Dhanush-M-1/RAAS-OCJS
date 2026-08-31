#include <bits/stdc++.h>
using namespace std;
int n;
int rt(int s) {
  int d[11];
  int len = 0;
  while (s) {
    d[len++] = s % n;
    s /= n;
  }
  int ans = 0;
  int t = 1;
  for (int i = 0; i < len; i++) {
    ans += d[i] * t;
    t *= 10;
  }
  return ans;
}
int main() {
  int i, j;
  cin >> n;
  for (i = 1; i < n; i++) {
    for (j = 1; j < n; j++) printf("%d ", rt(i * j));
    printf("\n");
  }
  return 0;
}
