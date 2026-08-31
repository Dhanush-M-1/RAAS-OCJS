#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, c1, r2, c2;
  cin >> r1 >> c1 >> r2 >> c2;
  map<pair<int, int>, int> valid;
  map<pair<int, int>, int> visited;
  int n;
  cin >> n;
  while (n--) {
    int r, a, b;
    cin >> r >> a >> b;
    for (int i = a; i < b + 1; i++) {
      valid[make_pair(r, i)] = 1;
    }
  }
  queue<pair<int, int> > q;
  q.push(make_pair(r1, c1));
  visited[make_pair(r1, c1)] = 0;
  while (!q.empty()) {
    pair<int, int> p = q.front();
    q.pop();
    int x = p.first, y = p.second;
    int level = visited[make_pair(x, y)] + 1;
    if ((y > 1) && (valid.find(make_pair(x, y - 1)) != valid.end()) &&
        (visited.find(make_pair(x, y - 1)) == visited.end())) {
      q.push(make_pair(x, y - 1));
      visited[make_pair(x, y - 1)] = level;
    }
    if ((y < 1000000000) && (valid.find(make_pair(x, y + 1)) != valid.end()) &&
        (visited.find(make_pair(x, y + 1)) == visited.end())) {
      q.push(make_pair(x, y + 1));
      visited[make_pair(x, y + 1)] = level;
    }
    if ((x > 1) && (valid.find(make_pair(x - 1, y)) != valid.end()) &&
        (visited.find(make_pair(x - 1, y)) == visited.end())) {
      q.push(make_pair(x - 1, y));
      visited[make_pair(x - 1, y)] = level;
    }
    if ((x < 1000000000) && (valid.find(make_pair(x + 1, y)) != valid.end()) &&
        (visited.find(make_pair(x + 1, y)) == visited.end())) {
      q.push(make_pair(x + 1, y));
      visited[make_pair(x + 1, y)] = level;
    }
    if ((y > 1) && (x > 1) &&
        (valid.find(make_pair(x - 1, y - 1)) != valid.end()) &&
        (visited.find(make_pair(x - 1, y - 1)) == visited.end())) {
      q.push(make_pair(x - 1, y - 1));
      visited[make_pair(x - 1, y - 1)] = level;
    }
    if ((y < 1000000000) && (x < 1000000000) &&
        (valid.find(make_pair(x + 1, y + 1)) != valid.end()) &&
        (visited.find(make_pair(x + 1, y + 1)) == visited.end())) {
      q.push(make_pair(x + 1, y + 1));
      visited[make_pair(x + 1, y + 1)] = level;
    }
    if ((x > 1) && (y < 1000000000) &&
        (valid.find(make_pair(x - 1, y + 1)) != valid.end()) &&
        (visited.find(make_pair(x - 1, y + 1)) == visited.end())) {
      q.push(make_pair(x - 1, y + 1));
      visited[make_pair(x - 1, y + 1)] = level;
    }
    if ((x < 1000000000) && (y > 1) &&
        (valid.find(make_pair(x + 1, y - 1)) != valid.end()) &&
        (visited.find(make_pair(x + 1, y - 1)) == visited.end())) {
      q.push(make_pair(x + 1, y - 1));
      visited[make_pair(x + 1, y - 1)] = level;
    }
    if (visited.find(make_pair(r2, c2)) != visited.end()) break;
  }
  if (visited.find(make_pair(r2, c2)) == visited.end())
    cout << -1 << "\n";
  else
    cout << visited[make_pair(r2, c2)] << "\n";
}
