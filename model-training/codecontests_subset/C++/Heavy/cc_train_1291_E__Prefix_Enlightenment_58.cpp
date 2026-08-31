#include <bits/stdc++.h>
using namespace std;
const int maxn = 6e5 + 10;
int f[maxn], n, k, w[maxn];
vector<int> v[maxn];
int Find(int x) { return f[x] == x ? x : f[x] = Find(f[x]); }
int ask(int x) {
  int y = (x <= k) ? x + k : x - k;
  x = Find(x);
  y = Find(y);
  if (x == 0)
    return w[y];
  else if (y == 0)
    return w[x];
  else
    return min(w[x], w[y]);
}
void Merge(int x, int y) {
  x = Find(x), y = Find(y);
  if (y == 0) swap(x, y);
  f[y] = x;
  if (x != 0) w[x] += w[y];
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> n >> k;
  string s;
  cin >> s;
  for (long long i = 1; i <= (long long)k; ++i) {
    int x;
    cin >> x;
    for (long long j = 1; j <= (long long)x; ++j) {
      int tem;
      cin >> tem;
      v[tem].push_back(i);
    }
    f[i] = i;
    f[i + k] = i + k;
    w[i + k] = 1;
  }
  int ans = 0;
  for (long long i = 1; i <= (long long)n; ++i) {
    if (v[i].size() == 1) {
      int x = v[i][0];
      if (x) {
        ans -= ask(x);
        if (s[i - 1] == '1')
          f[Find(x + k)] = 0;
        else
          f[Find(x)] = 0;
        ans += ask(x);
      }
    } else {
      int x = 0, y = 0;
      if (v[i].size() == 2) {
        x = v[i][0], y = v[i][1];
      }
      if (s[i - 1] == '1') {
        if (Find(x) != Find(y)) {
          ans -= (ask(x) + ask(y));
          Merge(x, y);
          Merge(x + k, y + k);
          ans += ask(x);
        }
      } else {
        if (Find(x + k) != Find(y)) {
          ans -= (ask(x) + ask(y));
          Merge(x + k, y);
          Merge(x, y + k);
          ans += ask(x);
        }
      }
    }
    cout << ans << "\n";
  }
}
