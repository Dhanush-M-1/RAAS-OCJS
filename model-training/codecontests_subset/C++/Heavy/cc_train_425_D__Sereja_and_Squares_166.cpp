#include <bits/stdc++.h>
using namespace std;
struct HashMap {
  vector<pair<int, int> > g[1000007];
  void ins(int x, int y) {
    int id = ((long long)(x)*1000000007 + y) % 1000007;
    g[id].push_back(make_pair(x, y));
  }
  bool get(int x, int y) {
    int id = ((long long)(x)*1000000007 + y) % 1000007;
    for (int i = 0; i < g[id].size(); i++) {
      if (g[id][i].first == x && g[id][i].second == y) return true;
    }
    return false;
  }
};
HashMap mp;
struct Point {
  int x, y;
} pt[100010];
vector<int> Row[100010];
int big[100010];
int main() {
  int n;
  while (scanf("%d", &n) != EOF) {
    for (int i = 0; i < n; i++) {
      scanf("%d%d", &pt[i].x, &pt[i].y);
      Row[pt[i].y].push_back(pt[i].x);
      mp.ins(pt[i].x, pt[i].y);
    }
    int ans = 0;
    int sz = sqrt(n) + 1;
    int bigcnt = 0;
    for (int i = 0; i < 100010; i++) {
      sort(Row[i].begin(), Row[i].end());
      if (Row[i].size() > sz) {
        big[bigcnt++] = i;
      } else {
        int len = Row[i].size();
        for (int j = 0; j < len; j++) {
          for (int k = j + 1; k < len; k++) {
            int d = Row[i][k] - Row[i][j];
            if (mp.get(Row[i][j] + d, i + d) && mp.get(Row[i][j], i + d)) {
              ans++;
            }
            if (mp.get(Row[i][j] + d, i - d) && mp.get(Row[i][j], i - d)) {
              if (i - d >= 0 && Row[i - d].size() > sz) {
                ans++;
              }
            }
          }
        }
      }
    }
    for (int i = 0; i < bigcnt; i++) {
      for (int j = i + 1; j < bigcnt; j++) {
        int d = big[j] - big[i];
        int p1 = 0, p2 = 0;
        int len1, len2;
        len1 = Row[big[i]].size();
        len2 = Row[big[j]].size();
        while (p1 < len1) {
          while (p2 < len2 && Row[big[j]][p2] < Row[big[i]][p1]) {
            p2++;
          }
          if (p1 < len1 && p2 < len2 && Row[big[i]][p1] == Row[big[j]][p2]) {
            if (mp.get(Row[big[i]][p1] + d, big[i]) &&
                mp.get(Row[big[j]][p2] + d, big[j])) {
              ans++;
            }
          }
          p1++;
        }
      }
    }
    printf("%d\n", ans);
  }
  return 0;
}
