#include <bits/stdc++.h>
using namespace std;
int n;
const int N = 100005;
set<int> X;
vector<int> pts[N];
unordered_set<int> Y[N];
vector<pair<int, int> > store;
const int MAGIC = 350;
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    int x, y;
    cin >> x >> y;
    X.insert(x);
    Y[x].insert(y);
    pts[x].push_back(y);
  }
  long long ans = 0;
  for (int x : X) {
    if (pts[x].size() < MAGIC) {
      sort(pts[x].begin(), pts[x].end());
      for (int i = 0; i < pts[x].size(); i++) {
        for (int j = i + 1; j < pts[x].size(); j++) {
          int y1 = pts[x][i], y2 = pts[x][j];
          int len = y2 - y1;
          if (x >= len and Y[x - len].count(y1) and Y[x - len].count(y2)) {
            ans++;
          }
        }
      }
    } else {
      for (int i = 0; i < store.size(); i++) {
        int x1 = store[i].first;
        int y1 = store[i].second;
        int len = x - x1;
        if (Y[x].count(y1) and Y[x].count(y1 - len) and Y[x1].count(y1 - len)) {
          ans++;
        }
      }
    }
    for (int y : pts[x]) {
      store.push_back(make_pair(x, y));
    }
  }
  cout << ans << "\n";
}
