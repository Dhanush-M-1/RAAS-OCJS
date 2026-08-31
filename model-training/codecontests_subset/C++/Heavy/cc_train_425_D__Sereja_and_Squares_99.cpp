#include <bits/stdc++.h>
using namespace ::std;
const int maxn = 1e5 + 500;
const int mod = 1e9 + 7;
const int rad = 380;
pair<int, int> inp[maxn];
vector<int> xx[maxn];
vector<int> yy[maxn];
stack<pair<int, int> > xxx[maxn * 4];
stack<pair<int, int> > yyy[maxn * 4];
bool por[maxn * 8];
int main() {
  ios_base::sync_with_stdio(0);
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    int x, y;
    cin >> x >> y;
    xx[x].push_back(y);
    inp[i] = make_pair(x, y);
  }
  int ans = 0;
  for (int i = 0; i < maxn; i++) {
    if (xx[i].size() < rad) {
      for (int j = 0; j < xx[i].size(); j++) {
        int y1 = xx[i][j];
        for (int k = j + 1; k < xx[i].size(); k++) {
          int yy2 = xx[i][k];
          xxx[i + abs(y1 - yy2)].push(make_pair(yy2, y1));
        }
      }
    }
    for (int j = 0; j < xx[i].size(); j++) {
      por[xx[i][j]] = 1;
    }
    while (!(xxx[i].empty())) {
      if (por[xxx[i].top().first] && por[xxx[i].top().second]) {
        ans++;
      }
      xxx[i].pop();
    }
    for (int j = 0; j < xx[i].size(); j++) {
      por[xx[i][j]] = 0;
    }
  }
  for (int i = maxn - 1; i >= 0; i--) {
    if (xx[i].size() < rad) {
      for (int j = 0; j < xx[i].size(); j++) {
        int y1 = xx[i][j];
        for (int k = j + 1; k < xx[i].size(); k++) {
          int yy2 = xx[i][k];
          if (i >= abs(y1 - yy2) && xx[i - abs(y1 - yy2)].size() >= rad) {
            xxx[i - abs(y1 - yy2)].push(make_pair(yy2, y1));
          }
        }
      }
    }
    for (int j = 0; j < xx[i].size(); j++) {
      por[xx[i][j]] = 1;
    }
    while (!(xxx[i].empty())) {
      if (por[xxx[i].top().first] && por[xxx[i].top().second]) {
        ans++;
      }
      xxx[i].pop();
    }
    for (int j = 0; j < xx[i].size(); j++) {
      por[xx[i][j]] = 0;
    }
  }
  for (int i = 0; i < n; i++) {
    if (xx[inp[i].first].size() >= rad) {
      yy[inp[i].second].push_back(inp[i].first);
    }
  }
  for (int i = 0; i < maxn; i++) {
    for (int j = 0; j < yy[i].size(); j++) {
      int x1 = yy[i][j];
      for (int k = j + 1; k < yy[i].size(); k++) {
        int x2 = yy[i][k];
        yyy[i + abs(x1 - x2)].push(make_pair(x2, x1));
      }
    }
    for (int j = 0; j < yy[i].size(); j++) {
      por[yy[i][j]] = 1;
    }
    while (!(yyy[i].empty())) {
      if (por[yyy[i].top().first] & por[yyy[i].top().second]) {
        ans++;
      }
      yyy[i].pop();
    }
    for (int j = 0; j < yy[i].size(); j++) {
      por[yy[i][j]] = 0;
    }
  }
  cout << ans;
}
