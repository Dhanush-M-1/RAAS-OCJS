#include <bits/stdc++.h>
using namespace std;
long long hsh(long long a, long long b) { return a * 1e7 + b; }
int main() {
  int n;
  while (cin >> n) {
    int sq = int(sqrt(n) + 1e-6);
    map<int, vector<int> > x, y;
    unordered_map<long long, bool> p;
    for (int i = 0; i < n; i++) {
      int tx, ty;
      scanf("%d %d", &tx, &ty);
      x[tx].push_back(ty);
      y[ty].push_back(tx);
      p[hsh(tx, ty)] = 1;
    }
    for (map<int, vector<int> >::iterator it = x.begin(); it != x.end(); it++)
      sort(it->second.begin(), it->second.end());
    for (map<int, vector<int> >::iterator it = y.begin(); it != y.end(); it++)
      sort(it->second.begin(), it->second.end());
    int res = 0;
    for (map<int, vector<int> >::iterator it = x.begin(); it != x.end(); it++) {
      if (it->second.size() < sq) {
        for (int i = 0; i < it->second.size(); i++) {
          int x1 = it->first, y1 = it->second[i];
          for (int j = i + 1; j < it->second.size(); j++) {
            int y2 = it->second[j], l = y2 - y1;
            if (p[hsh(x1 + l, y1)] && p[hsh(x1 + l, y2)]) res++;
          }
        }
      } else {
        for (int i = 0; i < it->second.size(); i++) {
          int x1 = it->first, y1 = it->second[i];
          for (int j =
                   upper_bound(y[y1].begin(), y[y1].end(), x1) - y[y1].begin();
               j < y[y1].size(); j++) {
            int x2 = y[y1][j], l = x2 - x1;
            if (p[hsh(x1, y1 + l)] && p[hsh(x2, y1 + l)]) res++;
          }
        }
      }
    }
    cout << res << endl;
  }
  return 0;
}
