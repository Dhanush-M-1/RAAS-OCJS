#include <bits/stdc++.h>
using namespace std;
const int MAX = 1e5 + 1e2;
pair<int, int> P[MAX];
int mxY[MAX], n;
vector<int> Y[MAX];
int vis[MAX];
bool find(int x, int y) {
  if (x >= MAX) return 0;
  return binary_search(Y[x].begin(), Y[x].end(), y);
}
int main() {
  scanf("%d", &n);
  for (int i = 0; i < (n); i++) scanf("%d %d", &P[i].first, &P[i].second);
  for (int i = 0; i < (n); i++) Y[P[i].first].push_back(P[i].second);
  for (int x = 0; x < (MAX); x++) sort(Y[x].begin(), Y[x].end());
  long long ans = 0;
  for (int x = 0; x < MAX; x++) {
    if (((int)Y[x].size()) * 1LL * ((int)Y[x].size()) <= n) {
      for (int i = 0; i < (((int)Y[x].size())); i++)
        for (int j = 0; j < (i); j++) {
          int len = Y[x][i] - Y[x][j];
          ans += find(x + len, Y[x][i]) && find(x + len, Y[x][j]);
        }
    } else {
      for (int len = 1; x + len < MAX; len++) {
        for (int y : Y[x + len]) {
          ans += find(x, y + len) && find(x, y) && find(x + len, y + len);
        }
      }
    }
  }
  cout << ans << endl;
  return 0;
}
