#include <bits/stdc++.h>
using namespace std;
template <class A>
ostream& output(ostream& out, A a, A b) {
  if (a == b) return out;
  out << *a;
  while (++a != b) out << ' ' << *a;
  return out;
}
template <class A>
ostream& operator<<(ostream& out, const vector<A>& v) {
  return output(out, v.begin(), v.end());
}
int a[1005], dep[1005], mark[1005];
bool dp[1005];
void dfs(int n) {
  if (!n) return;
  if (mark[n]) return;
  mark[n] = true;
  dfs(a[n]);
}
int main() {
  int n, x;
  while (2 == scanf("%d%d", &n, &x)) {
    for (int i = 1; i <= n; ++i) {
      int x;
      scanf("%d", &x);
      a[i] = x;
    }
    memset(mark, 0, sizeof mark);
    memset(dep, 0, sizeof dep);
    memset(dp, 0, sizeof dp);
    for (int i = 1; i <= n; ++i) {
      dfs(a[i]);
    }
    int base = 0;
    dp[0] = true;
    for (int i = 1; i <= n; ++i) {
      if (!mark[i]) {
        int j = i, c = 0, b = false;
        while (true) {
          ++c;
          if (j == x) {
            c = 0;
            b = true;
          }
          j = a[j];
          if (!j) break;
        }
        if (b) {
          base = c;
          continue;
        }
        for (int j = n; j >= c; --j) {
          dp[j] = dp[j] || dp[j - c];
        }
      }
    }
    (std::cerr << "base"
               << ": " << (base) << std::endl);
    for (int i = 0; i < n; ++i) {
      if (dp[i]) printf("%d\n", i + base + 1);
    }
  }
}
