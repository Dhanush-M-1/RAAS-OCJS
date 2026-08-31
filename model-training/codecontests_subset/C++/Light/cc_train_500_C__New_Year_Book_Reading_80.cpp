#include <bits/stdc++.h>
using namespace std;
const int M = 200005;
int w[M], n, m, ans, sum, bk[M];
bool vis[M];
int main() {
  ios::sync_with_stdio(0);
  cout.tie(0);
  cin.tie(0);
  cin >> n >> m;
  for (int i = 1; i <= n; ++i) {
    cin >> w[i];
  }
  for (int i = 1; i <= m; ++i) {
    cin >> bk[i];
    for (int j = i - 1; j >= 1; --j) {
      if (bk[j] == bk[i]) {
        for (int w = i - 1; w >= j; --w) vis[bk[w]] = 0;
        break;
      }
      if (!vis[bk[j]]) sum += w[bk[j]];
      vis[bk[j]] = 1;
      if (j == 1) {
        for (int w = i - 1; w >= j; --w) vis[bk[w]] = 0;
      }
    }
  }
  cout << sum << endl;
}
