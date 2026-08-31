#include <bits/stdc++.h>
using namespace std;
int n;
bool blocked[(int)1e6] = {0};
int last[(int)1e6];
int f(const int p) {
  int ans = 0;
  int lastPlaced = -1;
  for (int i = 0; i < n; i += p) {
    if (blocked[i]) {
      i = last[i];
      if (i <= lastPlaced) return n + 5;
    }
    lastPlaced = i;
    ++ans;
    assert(!blocked[i]);
  }
  return ans;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int m, k;
  cin >> n >> m >> k;
  vector<int> a(k + 1, 0);
  for (int i = 0; i < m; ++i) {
    int s;
    cin >> s;
    if (!s) {
      cout << -1;
      return 0;
    }
    last[s] = blocked[s - 1] ? last[s - 1] : s - 1;
    blocked[s] = true;
  }
  for (int i = 1; i <= k; ++i) cin >> a[i];
  long long ans = 4e18;
  for (int i = k; i >= 1; --i) {
    if ((long long)a[i] * ((n + i - 1) / i) >= ans) continue;
    long long cnt = f(i);
    if (cnt > n + 1) continue;
    ans = min(ans, cnt * a[i]);
  }
  cout << (ans < (long long)4e18 ? ans : -1);
  return 0;
}
