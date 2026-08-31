#include <bits/stdc++.h>
using namespace std;
map<pair<int, int>, bool> m;
map<pair<int, int>, int> dist;
map<pair<int, int>, bool> visited;
int main() {
  pair<int, int> init;
  pair<int, int> final;
  cin >> init.first >> init.second >> final.first >> final.second;
  m[init] = true;
  m[final] = true;
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    int r, a, b;
    cin >> r >> a >> b;
    for (int j = a; j <= b; j++) {
      m[make_pair(r, j)] = true;
    }
  }
  queue<pair<int, int> > q;
  q.push(init);
  visited[init] = true;
  dist[init] = 0;
  while (!q.empty()) {
    pair<int, int> curr = q.front();
    q.pop();
    int x = curr.first;
    int y = curr.second;
    int a = x - 1;
    int b = y;
    if ((m[make_pair(a, b)] == true) && (!visited[make_pair(a, b)])) {
      q.push(make_pair(a, b));
      visited[make_pair(a, b)] = true;
      dist[make_pair(a, b)] = dist[curr] + 1;
    }
    a = x + 1;
    b = y;
    if ((m[make_pair(a, b)] == true) && (!visited[make_pair(a, b)])) {
      q.push(make_pair(a, b));
      visited[make_pair(a, b)] = true;
      dist[make_pair(a, b)] = dist[curr] + 1;
    }
    a = x;
    b = y - 1;
    if ((m[make_pair(a, b)] == true) && (!visited[make_pair(a, b)])) {
      q.push(make_pair(a, b));
      visited[make_pair(a, b)] = true;
      dist[make_pair(a, b)] = dist[curr] + 1;
    }
    a = x;
    b = y + 1;
    if ((m[make_pair(a, b)] == true) && (!visited[make_pair(a, b)])) {
      q.push(make_pair(a, b));
      visited[make_pair(a, b)] = true;
      dist[make_pair(a, b)] = dist[curr] + 1;
    }
    a = x - 1;
    b = y - 1;
    if ((m[make_pair(a, b)] == true) && (!visited[make_pair(a, b)])) {
      q.push(make_pair(a, b));
      visited[make_pair(a, b)] = true;
      dist[make_pair(a, b)] = dist[curr] + 1;
    }
    a = x - 1;
    b = y + 1;
    if ((m[make_pair(a, b)] == true) && (!visited[make_pair(a, b)])) {
      q.push(make_pair(a, b));
      visited[make_pair(a, b)] = true;
      dist[make_pair(a, b)] = dist[curr] + 1;
    }
    a = x + 1;
    b = y - 1;
    if ((m[make_pair(a, b)] == true) && (!visited[make_pair(a, b)])) {
      q.push(make_pair(a, b));
      visited[make_pair(a, b)] = true;
      dist[make_pair(a, b)] = dist[curr] + 1;
    }
    a = x + 1;
    b = y + 1;
    if ((m[make_pair(a, b)] == true) && (!visited[make_pair(a, b)])) {
      q.push(make_pair(a, b));
      visited[make_pair(a, b)] = true;
      dist[make_pair(a, b)] = dist[curr] + 1;
    }
  }
  if (dist.count(final) == 0) {
    cout << -1;
    return 0;
  }
  cout << dist[final] << endl;
}
