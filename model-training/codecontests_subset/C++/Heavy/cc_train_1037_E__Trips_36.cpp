#include <bits/stdc++.h>
using namespace std;
int n, m, k, numOn, res[200000];
set<int> f[200000];
bool on[200000];
vector<pair<int, int> > v;
queue<int> toRemove;
void update() {
  while (!toRemove.empty()) {
    int r = toRemove.front();
    toRemove.pop();
    numOn--;
    for (auto next : f[r]) {
      f[next].erase(r);
      if (on[next] && ((int)(f[next]).size()) < k) {
        on[next] = 0;
        toRemove.push(next);
      }
    }
    f[r].clear();
  }
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> n >> m >> k;
  for (int i = 0; i < (m); i++) {
    int x, y;
    cin >> x >> y;
    x--, y--;
    v.push_back(make_pair(x, y));
    f[x].insert(y), f[y].insert(x);
  }
  for (int i = 0; i < (n); i++) on[i] = 1;
  numOn = n;
  for (int i = 0; i < (n); i++)
    if (((int)(f[i]).size()) < k) {
      on[i] = 0;
      toRemove.push(i);
    }
  update();
  res[m - 1] = numOn;
  for (int i = (m)-1; i >= (1); i--) {
    int x = v[i].first, y = v[i].second;
    f[x].erase(y), f[y].erase(x);
    if (on[x] && ((int)(f[x]).size()) < k) {
      on[x] = 0;
      toRemove.push(x);
    }
    if (on[y] && ((int)(f[y]).size()) < k) {
      on[y] = 0;
      toRemove.push(y);
    }
    update();
    res[i - 1] = numOn;
  }
  for (int i = 0; i < (m); i++) cout << res[i] << "\n";
}
