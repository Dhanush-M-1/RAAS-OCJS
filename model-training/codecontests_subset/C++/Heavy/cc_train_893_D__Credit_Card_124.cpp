#include <bits/stdc++.h>
using namespace std;
inline int get_int() {
  int res, c, t = 1;
  while (!isdigit(c = getchar()))
    if (c == '-') t = -1;
  for (res = c - '0'; isdigit(c = getchar());) res = res * 10 + c - '0';
  return res * t;
}
constexpr int MAXN = 100000;
int A[MAXN + 10], B[MAXN + 10];
int n, d;
int main() {
  n = get_int();
  d = get_int();
  int bef = 0;
  for (int i = 1; i <= n; i++) {
    int c = get_int();
    A[i] = A[i - 1] + c;
    if (c == 0 && bef + A[i] < 0) {
      bef += -(A[i] + bef);
    }
    if (A[i] + bef > d) {
      cout << -1 << endl;
      return 0;
    }
  }
  B[n] = d - A[n];
  for (int i = n - 1; i >= 1; i--) {
    B[i] = min(B[i + 1], d - A[i]);
  }
  bef = 0;
  int cnt = 0;
  for (int i = 1; i <= n; i++) {
    if (A[i] - A[i - 1] == 0 && bef + A[i] < 0) {
      if (bef < B[i]) bef = B[i], cnt++;
    }
  }
  cout << cnt << endl;
}
