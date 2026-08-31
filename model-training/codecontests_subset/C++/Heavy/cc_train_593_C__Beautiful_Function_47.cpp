#include <bits/stdc++.h>
using namespace std;
int n;
int x[50], y[50], r[50];
int f(int t) {
  return (
      ((0 + (((abs((t - 0)) + t) - 0) * 0)) + (((abs((t - 1)) + t) - 1) * 5)) +
      (((abs((t - 2)) + t) - 2) * 0));
}
int g(int t) {
  return (((0 + (((abs((t - 0)) + t) - 0) * 5)) +
           (((abs((t - 1)) + t) - 1) * (0 - 10))) +
          (((abs((t - 2)) + t) - 2) * 10));
}
string i2s(int x) {
  char tmp[10];
  sprintf(tmp, "%d", x);
  return tmp;
}
int d[100];
string solve(int *a) {
  string res = "0";
  int prev = 0;
  for (int i = 0; i < n; i++) {
    int prev = 0;
    for (int j = 0; j < i; j++) {
      prev += (i - j + 1) * 2 * d[j];
    }
    int dist = a[i] - prev;
    string offset = "";
    if (dist >= 0) {
      dist /= 2;
      offset = i2s(dist);
      d[i] = dist;
    } else {
      dist = -dist;
      dist /= 2;
      offset = "(0-" + i2s(dist) + ")";
      d[i] = -dist;
    }
    string step = "((abs((t-" + i2s(i) + "))+t)-" + i2s(i) + ")";
    string jump = "(" + step + "*" + offset + ")";
    res = "(" + res + "+" + jump + ")";
  }
  return res;
}
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) cin >> x[i] >> y[i] >> r[i];
  cout << solve(x) << endl << solve(y) << endl;
  return 0;
}
