#include <bits/stdc++.h>
using namespace std;
const int MAXN = 511111;
const long long MOD = 1e9 + 7;
const double eps = 1e-6;
const long long MAXL = (long long)(0x7fffffffffffffff);
const int MAXI = 0x7fffffff;
int books[555];
int w[555];
int readorder[1111];
bool vis[555];
int main() {
  int n, m;
  while (cin >> n >> m) {
    memset(vis, 0, sizeof(vis));
    int c = 1;
    for (int i = 1; i <= n; i++) {
      cin >> w[i];
    }
    for (int i = 1; i <= m; i++) {
      cin >> readorder[i];
      if (!vis[readorder[i]]) {
        vis[readorder[i]] = true;
        books[c++] = readorder[i];
      }
    }
    int ans = 0;
    for (int i = 1; i <= m; i++) {
      int p = 0;
      for (int j = 1; j <= n; j++) {
        if (books[j] == readorder[i]) {
          p = j;
          break;
        }
        ans += w[books[j]];
      }
      for (int j = p; j > 1; j--) {
        books[j] = books[j - 1];
      }
      books[1] = readorder[i];
    }
    cout << ans << endl;
  }
}
