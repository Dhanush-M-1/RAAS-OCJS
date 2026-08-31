#include <bits/stdc++.h>
template <typename T>
inline void chkmin(T &x, T y) {
  x = min(x, y);
}
template <typename T>
inline void chkmax(T &x, T y) {
  x = max(x, y);
}
template <typename T>
inline void read(T &x) {
  T f = 1;
  x = 0;
  char c = getchar();
  for (; !isdigit(c); c = getchar())
    if (c == '-') f = -f;
  for (; isdigit(c); c = getchar()) x = (x << 3) + (x << 1) + c - '0';
  x *= f;
}
const int N = 80;
int n, k;
struct Info {
  int first, second;
  int home;
  bool operator<(const Info &o) const {
    if (first != o.first)
      return first < o.first;
    else
      return second < o.second;
  }
} a[N];
int memo[N][N];
inline int dp(int on, int used) {
  if (used > k) return -1e9;
  int &ans = memo[on][used];
  if (ans != -1) return ans;
  if (on == n) {
    return ans = used == k ? 0 : int(-1e9);
  } else {
    return ans = std::max(
               dp(on + 1, used) + (k - 1) * a[on].first,
               dp(on + 1, used + 1) + a[on].second + used * a[on].first);
  }
}
int main() {
  int T;
  read(T);
  while (T--) {
    read(n);
    read(k);
    memset(memo, -1, sizeof(memo));
    for (int i = 0; i < n; ++i) {
      read(a[i].second);
      read(a[i].first);
      a[i].second = -a[i].second;
      a[i].home = i + 1;
    }
    std ::sort(a, a + n);
    for (int i = 0; i < n; ++i) a[i].second = -a[i].second;
    std ::vector<int> bas;
    std ::vector<bool> got(n + 1, false);
    for (int i = 0, j = 0; i < n;) {
      if (dp(i, j) == dp(i + 1, j) + (k - 1) * a[i].first) {
        ++i;
      } else {
        bas.push_back(a[i].home);
        got[a[i].home] = true;
        ++i;
        ++j;
      }
    }
    std ::vector<int> ans;
    assert((int)bas.size() == k);
    for (int i = 0; i + 1 < k; ++i) ans.push_back(bas[i]);
    for (int i = 1; i <= n; ++i) {
      if (!got[i]) {
        ans.push_back(i);
        ans.push_back(-i);
      }
    }
    ans.push_back(bas.back());
    printf("%d\n", (int)ans.size());
    for (auto x : ans) printf("%d ", x);
    printf("\n");
  }
  return 0;
}
