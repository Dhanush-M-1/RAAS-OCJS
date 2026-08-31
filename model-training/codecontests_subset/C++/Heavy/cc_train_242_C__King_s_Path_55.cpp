#include <bits/stdc++.h>
using namespace std;
int dx[8] = {0, 1, 1, 1, 0, -1, -1, -1};
int dy[8] = {1, 1, 0, -1, -1, -1, 0, 1};
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  pair<int, int> ini, fin;
  cin >> ini.first >> ini.second >> fin.first >> fin.second;
  int n;
  cin >> n;
  set<pair<int, int>> se;
  for (int i = 0; i < n; i++) {
    int r, be, en;
    cin >> r >> be >> en;
    for (int j = be; j <= en; j++) {
      se.insert({r, j});
    }
  }
  queue<pair<int, pair<int, int>>> q;
  q.push({0, ini});
  while (q.size()) {
    pair<int, pair<int, int>> t = q.front();
    if (t.second == fin) {
      cout << t.first;
      return 0;
    }
    q.pop();
    for (int j = 0; j < 8; j++) {
      if (se.count(
              make_pair(t.second.first + dx[j], t.second.second + dy[j]))) {
        q.push(make_pair(t.first + 1, make_pair(t.second.first + dx[j],
                                                t.second.second + dy[j])));
        se.erase(make_pair(t.second.first + dx[j], t.second.second + dy[j]));
      }
    }
  }
  cout << "-1";
}
