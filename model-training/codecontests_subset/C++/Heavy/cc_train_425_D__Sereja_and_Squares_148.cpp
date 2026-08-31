#include <bits/stdc++.h>
using namespace std;
using ld = long double;
using ull = unsigned long long;
template <class T>
inline T gcd(T a, T b) {
  return !a ? b : gcd(b % a, a);
}
template <class T>
inline T lcm(T a, T b) {
  return (a * b) / gcd(a, b);
}
mt19937 rnd(time(0));
const int N = 2e5 + 5;
unordered_set<int> lineX[N], lineY[N];
unordered_map<long long, bool> cnt;
void solve() {
  int n;
  cin >> n;
  vector<int> a(n), b(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i] >> b[i];
    cnt[a[i] * 1ll * 1e6 + b[i]] = 1;
  }
  for (int i = 0; i < n; i++) {
    lineX[b[i]].insert(a[i]);
    lineY[a[i]].insert(b[i]);
  }
  int ans = 0;
  for (int i = 0; i < n; i++) {
    if ((int)lineX[b[i]].size() < (int)lineY[a[i]].size()) {
      int curX = a[i];
      for (int nextX : lineX[b[i]]) {
        if (nextX - curX > 0) {
          ans += (cnt[curX * 1ll * 1e6 + b[i] + (nextX - curX)] &&
                  cnt[nextX * 1ll * 1e6 + b[i] + (nextX - curX)]);
        }
      }
    } else {
      int curY = b[i];
      for (int nextY : lineY[a[i]]) {
        if (nextY - curY > 0) {
          ans += (cnt[(a[i] + (nextY - curY)) * 1ll * 1e6 + curY] &&
                  cnt[(a[i] + (nextY - curY)) * 1ll * 1e6 + nextY]);
        }
      }
    }
  }
  cout << ans << '\n';
  return;
}
int main() {
  ios_base ::sync_with_stdio(0);
  cin.tie(0), cout.tie(0);
  int t = 1;
  while (t-- > 0) {
    solve();
  }
  return 0;
}
