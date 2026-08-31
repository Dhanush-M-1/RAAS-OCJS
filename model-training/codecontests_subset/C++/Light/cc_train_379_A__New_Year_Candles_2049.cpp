#include <bits/stdc++.h>
using namespace std;
int n, i, x, y, z, j, len, cnt(0), sum = 0, a, b, c, temp, d, res = 0, k;
int dp[1000];
int two[1000][1000];
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
string str, st;
int check(int n) {}
int main() {
  cin >> a >> b;
  res += a;
  while (a >= b) {
    d = a / b;
    res += d;
    a = d + a % b;
  }
  cout << res << endl;
  return 0;
}
