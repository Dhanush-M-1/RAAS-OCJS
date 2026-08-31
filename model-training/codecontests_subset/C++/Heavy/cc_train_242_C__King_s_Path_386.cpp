#include <bits/stdc++.h>
using namespace std;
int n;
map<pair<int, int>, int> mp;
vector<int> adj[100001];
bool vis[100001];
int dis[100001];
void bfs(int i) {
  queue<int> q;
  q.push(i);
  dis[i] = 0;
  vis[i] = true;
  while (!q.empty()) {
    int v = q.front();
    q.pop();
    for (auto it : adj[v]) {
      if (!vis[it]) {
        vis[it] = true;
        dis[it] = dis[v] + 1;
        q.push(it);
      }
    }
  }
}
int main() {
  pair<int, int> st, en;
  cin >> st.first >> st.second >> en.first >> en.second;
  cin >> n;
  int j = 0;
  for (int i = 0; i < n; i++) {
    int r, a, b;
    cin >> r >> a >> b;
    for (int h = a; h <= b; h++) {
      if (mp.find(make_pair(r, h)) == mp.end()) {
        mp[make_pair(r, h)] = j;
        j++;
        for (int dx = -1; dx <= 1; dx++)
          for (int dy = -1; dy <= 1; dy++) {
            if (!(dx == 0 && dy == 0)) {
              if (mp.find(make_pair(r + dx, h + dy)) != mp.end()) {
                adj[mp[make_pair(r, h)]].push_back(
                    mp[make_pair(r + dx, h + dy)]);
                adj[mp[make_pair(r + dx, h + dy)]].push_back(
                    mp[make_pair(r, h)]);
              }
            }
          }
      }
    }
  }
  bfs(mp[st]);
  if (dis[mp[en]] == 0) dis[mp[en]] = -1;
  cout << dis[mp[en]];
  return 0;
}
