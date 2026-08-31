#include <bits/stdc++.h>
using namespace std;
struct HashMap {
  vector<pair<int, int> > g[1000007];
  void ins(int x, int y) {
    int id = ((long long)x * 1000000007 + y) % 1000007;
    g[id].push_back(make_pair(x, y));
  }
  bool get(int x, int y) {
    int id = ((long long)x * 1000000007 + y) % 1000007;
    for (int i = 0; i < g[id].size(); i++)
      if (g[id][i].first == x && g[id][i].second == y) return true;
    return false;
  }
};
int n;
HashMap mp;
vector<int> row[100011];
vector<int> rateB;
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    int x, y;
    scanf("%d%d", &x, &y);
    row[y].push_back(x);
    mp.ins(x, y);
  }
  int di = (int)sqrt(n);
  long long int ans = 0;
  for (int a = 0; a <= 100000; a++) {
    if (row[a].size() != 0) {
      sort(row[a].begin(), row[a].end());
      if (row[a].size() <= di) {
        for (int i = 0; i < row[a].size(); i++) {
          for (int j = i + 1; j < row[a].size(); j++) {
            int x1 = row[a][i];
            int x2 = row[a][j];
            int dis = x2 - x1;
            if (mp.get(x1, a + dis) && mp.get(x2, a + dis)) ans++;
            if (a - dis >= 0 && row[a - dis].size() > di &&
                (mp.get(x1, a - dis) && mp.get(x2, a - dis)))
              ans++;
          }
        }
      } else
        rateB.push_back(a);
    }
  }
  for (int i = 0; i < rateB.size(); i++) {
    for (int j = i + 1; j < rateB.size(); j++) {
      int a = rateB[i];
      int b = rateB[j];
      int u = 0, p = 0;
      int dis = b - a;
      while (u < row[a].size() && p < row[b].size()) {
        if (row[a][u] < row[b][p])
          u++;
        else if (row[a][u] > row[b][p])
          p++;
        else {
          int x1 = row[a][u];
          if (mp.get(x1 + dis, a) && mp.get(x1 + dis, b)) ans++;
          u++;
          p++;
        }
      }
    }
  }
  printf("%I64d\n", ans);
  return 0;
}
