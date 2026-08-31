#include <bits/stdc++.h>
const int N = 32;
int n;
int c[N], d[N];
int toint(int x[]) {
  int sum = 0;
  for (int i = N - 1; i >= 0; --i) {
    sum <<= 1;
    sum += x[i];
  }
  return sum;
}
int ask(int x, int y) {
  std::cout << "? " << x << " " << y << std::endl;
  fflush(stdout);
  int ans;
  std::cin >> ans;
  return ans;
}
int q[N][2];
int main() {
  std::ios::sync_with_stdio(false), std::cin.tie(0), std::cout.tie(0);
  for (int i = 0; i < N; ++i)
    for (int j = 0; j < 2; ++j) q[i][j] = -2;
  for (int i = 29; i >= 0; --i) {
    int ans0, ans1;
    if (q[i][0] == -2) {
      ans0 = ask(toint(c), toint(d));
    } else {
      ans0 = q[i][0];
    }
    c[i] = d[i] = 1;
    ans1 = ask(toint(c), toint(d));
    if (ans0 != ans1) {
      if (ans0 == 1) {
        c[i] = 1;
        d[i] = 0;
      } else {
        c[i] = 0;
        d[i] = 1;
      }
    } else {
      if (i > 0) {
        q[i - 1][0] = ans0;
      }
      c[i] = 1;
      d[i] = 0;
      int ans2 = ask(toint(c), toint(d));
      if (ans2 == -1) {
        c[i] = d[i] = 1;
      } else {
        c[i] = d[i] = 0;
      }
    }
  }
  std::cout << "! " << toint(c) << " " << toint(d) << std::endl;
  return 0;
}
