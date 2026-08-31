#include <bits/stdc++.h>
using namespace std;
const double PI = 3.14159265358979323846;
const double eps = (1e-8);
string g[5205];
int sum[5205][5205];
int getSum(int i1, int j1, int i2, int j2) {
  int ret = sum[i2][j2];
  if (i1 - 1 >= 0) {
    ret -= sum[i1 - 1][j2];
  }
  if (j1 - 1 >= 0) {
    ret -= sum[i2][j1 - 1];
  }
  if (i1 - 1 >= 0 && j1 - 1 >= 0) ret += sum[i1 - 1][j1 - 1];
  return ret;
}
int n;
bool check(int x) {
  for (int j = 0; j < n; j += x) {
    for (int i = 0; i < n; i += x) {
      if (getSum(i, j, i + x - 1, j + x - 1) != x * x &&
          getSum(i, j, i + x - 1, j + x - 1) != 0)
        return false;
    }
  }
  return true;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < n / 4; ++j) {
      char c;
      cin >> c;
      if (isalpha(c)) {
        c -= 'A' - 10;
      } else
        c -= '0';
      string bin;
      while (c) {
        bin += c % 2 + '0';
        c /= 2;
      }
      while ((int)(bin).size() < 4) bin += '0';
      reverse(bin.begin(), bin.end());
      g[i] += bin;
    }
  }
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < n; ++j) {
      sum[i][j] = g[i][j] - '0';
    }
    partial_sum(sum[i], sum[i] + n, sum[i]);
    for (int j = 0; j < n; ++j) {
      if (i - 1 >= 0) {
        sum[i][j] += sum[i - 1][j];
      }
    }
  }
  for (int i = n; i > 1; --i) {
    if (n % i == 0 && check(i)) {
      cout << i << '\n';
      return 0;
    }
  }
  cout << 1 << '\n';
  return 0;
}
