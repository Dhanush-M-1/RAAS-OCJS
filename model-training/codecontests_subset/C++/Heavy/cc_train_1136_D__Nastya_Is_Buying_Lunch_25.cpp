#include <bits/stdc++.h>
using namespace std;
const long mm = 998244353;
const int maxn = 200005;
template <class TYPE>
TYPE gcd(TYPE x, TYPE y) {
  if (y)
    return gcd(y, x % y);
  else
    return x;
}
template <class TYPE>
TYPE lcm(TYPE x, TYPE y) {
  TYPE t = gcd(x, y);
  return t ? (x / t * y) : 0;
}
map<int, bool> mp[300005];
int n, m;
int *p;
bool solve(int i, int x) {
  if (i < 0) return false;
  for (int j = i; j >= 0; j--) {
    if (mp[p[j]][x] == true) {
      bool check = true;
      for (int kk = j + 1; kk <= i; kk++) {
        if (mp[p[j]][p[kk]] == false) {
          check = false;
          break;
        }
      }
      if (check == true) {
        for (int kk = j; kk < i; kk++) {
          swap(p[kk], p[kk + 1]);
        }
        return true;
      }
    }
  }
  return false;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> n >> m;
  p = new int[n];
  for (int i = 0; i < n; i++) cin >> p[i];
  for (int i = 0; i < m; i++) {
    int x, y;
    cin >> x >> y;
    mp[x][y] = true;
  }
  int cnt = 0;
  for (int i = n - 1; i > 0; i--) {
    if (solve(i - 1, p[i]) == true) {
      cnt++;
      swap(p[i - 1], p[i]);
    } else
      break;
  }
  cout << cnt;
  return 0;
}
