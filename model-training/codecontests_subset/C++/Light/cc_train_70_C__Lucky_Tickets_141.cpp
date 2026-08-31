#include <bits/stdc++.h>
using namespace std;
int mx, my, w, cnt, px, py, rx, ry, dp[100010];
double t;
map<double, int> ma, mb;
long long res = 10000000000000;
int rev(int a) {
  if (dp[a] != 0) return dp[a];
  int ret = 0;
  while (a) {
    ret *= 10;
    ret += a % 10;
    a /= 10;
  }
  return dp[a] = ret;
}
int main() {
  cin >> mx >> my >> w;
  for (int i = 1; i <= my; i++) mb[(rev(i) * 1.0 / i)]++;
  for (int i = 1; i <= mx; i++) cnt += mb[i * 1.0 / rev(i)];
  if (cnt < w) {
    cout << -1 << endl;
    return 0;
  }
  cnt = mb[1.0];
  py = my;
  ma[1.0]++;
  px = 1;
  while (py >= 1 && px <= mx) {
    if (cnt >= w) {
      if (res > (long long)px * py) {
        res = (long long)px * py;
        rx = px;
        ry = py;
      }
      t = rev(py) * 1.0 / py;
      cnt -= ma[t];
      mb[t]--;
      py--;
    } else {
      px++;
      t = px * 1.0 / rev(px);
      cnt += mb[t];
      ma[t]++;
    }
  }
  cout << rx << " " << ry << endl;
}
