#include <bits/stdc++.h>
using namespace std;
const int maxn = ((int)3e5) + 5;
unordered_set<int> byX[maxn], byY[maxn];
vector<pair<int, int>> points;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n;
  long long int t = 0;
  cin >> n;
  for (int i = 0; i < n; i++) {
    int x = rand() % 100000, y = rand() % 100000;
    cin >> x >> y;
    points.push_back(make_pair(x, y));
    byX[x].insert(y);
    byY[y].insert(x);
  }
  long long int ans = 0;
  for (int i = 0; i < maxn; i++) {
    int x = i;
    if (byX[i].size() < 300) {
      for (int y1 : byX[x]) {
        for (int y2 : byX[x]) {
          t++;
          if (y1 < y2) {
            int dist = y2 - y1;
            if (byX[x + dist].find(y1) != byX[x + dist].end() &&
                byX[x + dist].find(y2) != byX[x + dist].end()) {
              ans++;
            }
          }
        }
      }
    } else {
      for (int y : byX[x]) {
        for (int x2 : byY[y]) {
          if (x2 > x) {
            t++;
            int dist = x2 - x;
            if (byX[x].find(y - dist) != byX[x].end() &&
                byX[x2].find(y - dist) != byX[x2].end()) {
              ans++;
            }
          }
        }
      }
    }
  }
  cout << ans;
  return 0;
}
