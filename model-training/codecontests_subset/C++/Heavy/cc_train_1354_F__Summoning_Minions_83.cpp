#include <bits/stdc++.h>
using namespace std;
const int N = 2e3 + 5;
int n, k;
struct node {
  int id, a, b;
  node(int i = 0, int _a = 0, int _b = 0) { id = i, a = _a, b = _b; }
  bool operator<(const node& a) const { return b < a.b; }
} p[N];
long long dp[N][N];
int pre[N][N];
int main() {
  int TTT;
  cin >> TTT;
  while (TTT--) {
    cin >> n >> k;
    long long ans = 0;
    for (int i = (1); i < (n + 1); i++) {
      cin >> p[i].a >> p[i].b;
      p[i].id = i;
    }
    sort(p + 1, p + n + 1);
    memset(dp, 0, sizeof(dp));
    for (int i = (1); i < (n + 1); i++) {
      dp[i][0] = dp[i - 1][0] + (long long)(k - 1) * p[i].b;
      for (int j = (1); j < (i + 1); j++) {
        long long x = dp[i - 1][j - 1] + (j - 1) * p[i].b + p[i].a;
        long long y = 0;
        if (i - 1 >= j) y = dp[i - 1][j] + (k - 1) * p[i].b;
        dp[i][j] = max(x, y);
        if (x > y)
          pre[i][j] = j - 1;
        else
          pre[i][j] = j;
      }
    }
    int u = k;
    vector<int> p1, p2;
    for (int i = n; i >= 1; --i) {
      if (pre[i][u] == u) {
        p2.push_back(p[i].id);
      } else
        u--, p1.push_back(p[i].id);
    }
    reverse(p1.begin(), p1.end());
    reverse(p2.begin(), p2.end());
    cout << (int)p1.size() + 2 * (int)p2.size() << "\n";
    for (int i = (0); i < (k - 1); i++) cout << p1[i] << " ";
    for (auto it : p2) cout << it << " " << -it << " ";
    cout << p1[k - 1] << "\n";
  }
  return 0;
}
