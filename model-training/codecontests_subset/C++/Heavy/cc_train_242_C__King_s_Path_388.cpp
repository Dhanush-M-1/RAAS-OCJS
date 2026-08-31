#include <bits/stdc++.h>
using namespace std;
int alowed[3] = {0, 1, -1};
int ans = 0;
string getS(int r, int c) {
  stringstream stringstream;
  stringstream << r;
  stringstream << "-";
  stringstream << c;
  return stringstream.str();
}
pair<int, int> getCoordinate(string str) {
  pair<int, int> co;
  int i;
  for (i = 0; str[i] != '-'; i++) {
    co.first *= 10;
    co.first += str[i] - '0';
  }
  i++;
  for (; i < str.length(); i++) {
    co.second *= 10;
    co.second += str[i] - '0';
  }
  return co;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  unordered_set<string> s;
  int x1, y1, x2, y2;
  cin >> x1 >> y1 >> x2 >> y2;
  int m;
  cin >> m;
  int r, a, b;
  while (m--) {
    cin >> r >> a >> b;
    for (int i = a; i <= b; i++) {
      s.insert(getS(r, i));
    }
  }
  queue<string> bfs;
  string be = getS(x1, y1);
  bfs.push(be);
  if (!s.count(be)) return cout << -1, 0;
  s.erase(be);
  while (!bfs.empty()) {
    int x = bfs.size();
    while (x--) {
      string str = bfs.front();
      bfs.pop();
      pair<int, int> cor = getCoordinate(str);
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          if (i == 0 && j == 0) continue;
          int xH = cor.first + alowed[i];
          int yH = cor.second + alowed[j];
          string s2 = getS(xH, yH);
          if (s.count(s2)) {
            s.erase(s2);
            bfs.push(s2);
            if (xH == x2 && yH == y2) return cout << ans + 1, 0;
          }
        }
      }
    }
    ans++;
  }
  cout << -1 << endl;
  return 0;
}
