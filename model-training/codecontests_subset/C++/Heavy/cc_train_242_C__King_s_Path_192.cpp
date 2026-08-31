#include <bits/stdc++.h>
using namespace std;
set<pair<int, int>> st;
map<pair<int, int>, int> mp;
map<pair<int, int>, vector<pair<int, int>>> g;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int xSt, ySt, xEn, yEn;
  int n;
  cin >> xSt >> ySt >> xEn >> yEn;
  cin >> n;
  for (int i = 0; i < n; i++) {
    int r, a, b;
    cin >> r >> a >> b;
    for (int j = a; j <= b; j++) {
      st.insert({r, j});
    }
  }
  for (auto it : st) {
    int x = it.first;
    int y = it.second;
    if (st.find({x - 1, y - 1}) != st.end()) {
      g[it].push_back({x - 1, y - 1});
    }
    if (st.find({x - 1, y}) != st.end()) {
      g[it].push_back({x - 1, y});
    }
    if (st.find({x - 1, y + 1}) != st.end()) {
      g[it].push_back({x - 1, y + 1});
    }
    if (st.find({x, y - 1}) != st.end()) {
      g[it].push_back({x, y - 1});
    }
    if (st.find({x, y + 1}) != st.end()) {
      g[it].push_back({x, y + 1});
    }
    if (st.find({x + 1, y - 1}) != st.end()) {
      g[it].push_back({x + 1, y - 1});
    }
    if (st.find({x + 1, y}) != st.end()) {
      g[it].push_back({x + 1, y});
    }
    if (st.find({x + 1, y + 1}) != st.end()) {
      g[it].push_back({x + 1, y + 1});
    }
  }
  mp[{xSt, ySt}] = 1;
  queue<pair<int, int>> q;
  q.push({xSt, ySt});
  while (q.size() > 0) {
    pair<int, int> pr = q.front();
    q.pop();
    for (auto it : g[pr]) {
      if (mp[it] == 0) {
        mp[it] = mp[pr] + 1;
        q.push(it);
      }
    }
  }
  cout << mp[{xEn, yEn}] - 1 << '\n';
}
