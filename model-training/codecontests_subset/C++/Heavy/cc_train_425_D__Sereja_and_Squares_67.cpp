#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC target( \
    "avx,avx2,fma,sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
using namespace std;
int MOD = 1e9 + 7;
const int N = 120000;
const int B = 300;
vector<int> xn[N];
bool exists(int x, int y) {
  if (x >= N) return false;
  return binary_search(xn[x].begin(), xn[x].end(), y);
}
int main() {
  ios::sync_with_stdio(0), cin.tie(0), cout.tie(0),
      cout << fixed << setprecision(20);
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    int x, y;
    cin >> x >> y;
    xn[x].push_back(y);
  }
  int ans = 0;
  for (int i = 0; i < N; i++) {
    sort(xn[i].begin(), xn[i].end());
  }
  for (int i = 0; i < N; i++) {
    if (xn[i].size() < B) {
      for (auto j : xn[i]) {
        for (auto j2 : xn[i]) {
          if (j >= j2) continue;
          int ds = j2 - j;
          if (exists(i + ds, j) && exists(i + ds, j2)) {
            ans++;
          }
        }
      }
    } else {
      for (int i2 = i + 1; i2 < N; i2++) {
        for (auto y : xn[i2]) {
          if (exists(i, y) && exists(i, y + i2 - i) && exists(i2, y + i2 - i)) {
            ans++;
          }
        }
      }
    }
  }
  cout << ans;
}
