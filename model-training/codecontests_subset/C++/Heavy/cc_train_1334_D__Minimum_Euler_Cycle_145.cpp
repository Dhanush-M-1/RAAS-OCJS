#include <bits/stdc++.h>
template <class T>
bool chmax(T &a, const T &b) {
  if (a < b) {
    a = b;
    return 1;
  }
  return 0;
}
template <class T>
bool chmin(T &a, const T &b) {
  if (a > b) {
    a = b;
    return 1;
  }
  return 0;
}
using namespace std;
int main(void) {
  cin.tie(0);
  ios::sync_with_stdio(false);
  int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    long long l, r;
    cin >> l >> r;
    int idx = 0;
    long long sum = 0;
    int lg = -1, rg = -1;
    int ls = -1, rs = -1;
    while ((lg == -1 || rg == -1) && idx < n - 1) {
      long long lsum = sum;
      sum += (long long)(n - 1 - idx) * 2;
      if (lg == -1 && l <= sum) lg = idx, ls = l - lsum;
      if (rg == -1 && r <= sum) rg = idx, rs = r - lsum;
      idx++;
    }
    if (lg == -1) lg = n - 1;
    if (rg == -1) rg = n - 1;
    lg++;
    rg++;
    for (int i = (int)(lg); i <= (int)(rg); i++) {
      if (i == n) {
        cout << "1 ";
        break;
      }
      long long from = 1, to = (long long)(n - i) * 2;
      if (i == lg) from = ls;
      if (i == rg) to = rs;
      for (int j = (int)(from); j <= (int)(to); j++) {
        if (j % 2 == 1) {
          cout << i << " ";
        } else {
          cout << i + j / 2 << " ";
        }
      }
    }
    cout << "\n";
  }
  return 0;
}
