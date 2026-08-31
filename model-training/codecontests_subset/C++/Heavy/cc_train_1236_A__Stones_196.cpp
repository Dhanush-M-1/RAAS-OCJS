#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, i, a, b, c;
  cin >> t;
  for (i = 0; i < t; i++) {
    int sum = 0;
    cin >> a >> b >> c;
    if (c >= 2 && b >= 1) {
      int p = min(b, c);
      if (p == c) {
        int m = c / 2;
        sum = sum + (m * 2) + m;
        c = c - sum;
        b = b - m;
      } else if (c >= 2 * b) {
        sum = sum + (b * 3);
        b = 0;
      } else {
        int m = c / 2;
        sum = sum + (m * 2) + m;
        c = c - sum;
        b = b - m;
      }
    }
    if (a >= 1 && b >= 2) {
      int q = min(a, b);
      if (q == b) {
        int n = b / 2;
        sum = sum + (2 * n) + n;
        b = b - (2 * n);
        a = a - n;
      } else if (b >= 2 * a) {
        sum = sum + (3 * a);
        a = 0;
      } else {
        int n = b / 2;
        sum = sum + (2 * n) + n;
        b = b - (2 * n);
        a = a - n;
      }
    }
    cout << sum << endl;
  }
}
