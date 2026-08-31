#include <bits/stdc++.h>
const int inf = 0xfffffff;
const long long INF = 1ll << 61;
using namespace std;
vector<int> G[100000 + 55];
int n;
int ans;
void init() {
  for (int i = 0; i < 100000 + 55; i++) G[i].clear();
}
bool input() {
  while (scanf("%d", &n) == 1) {
    for (int i = 0; i < n; i++) {
      int x, y;
      scanf("%d %d", &x, &y);
      G[x].push_back(y);
    }
    return false;
  }
  return true;
}
bool find(int x, int y) {
  if (x >= 100000 + 55) return false;
  return binary_search(G[x].begin(), G[x].end(), y);
}
void cal() {
  for (int i = 0; i < 100000 + 55; i++) sort(G[i].begin(), G[i].end());
  int sq = sqrt(n * 1.00);
  ans = 0;
  for (int i = 0; i < 100000 + 55; i++) {
    int len = G[i].size();
    if (!len) continue;
    if (len < sq) {
      for (int j = 0; j < len; j++) {
        for (int k = j + 1; k < len; k++) {
          int d = G[i][k] - G[i][j];
          if (find(i + d, G[i][j]) && find(i + d, G[i][k])) ans++;
        }
      }
    } else {
      for (int j = i + 1; j < 100000 + 55; j++) {
        for (int k = 0; k < G[j].size(); k++) {
          int d = j - i;
          if (find(i, G[j][k]) && find(j, G[j][k] + d) && find(i, G[j][k] + d))
            ans++;
        }
      }
    }
  }
}
void output() { printf("%d\n", ans); }
int main() {
  while (true) {
    init();
    if (input()) return 0;
    cal();
    output();
  }
}
