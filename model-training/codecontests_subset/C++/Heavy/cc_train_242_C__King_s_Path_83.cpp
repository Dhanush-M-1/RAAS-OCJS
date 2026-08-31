#include <bits/stdc++.h>
using std::cin;
using std::cout;
using std::endl;
using std::make_pair;
using std::pair;
using std::sort;
using std::string;
using std::swap;
using std::vector;
using namespace std;
const int MAXN = 100005;
map<int, vector<int>> m;
int mas[MAXN][2];
bool solved = false;
int answer = -1;
void bfs(int x, int y, int xx, int yy) {
  queue<pair<int, int>> q;
  q.push(make_pair(x, y));
  map<pair<int, int>, bool> used;
  map<pair<int, int>, int> d;
  used[make_pair(x, y)] = true;
  while (!q.empty()) {
    pair<int, int> v = q.front();
    if (v.first == xx && v.second == yy) {
      solved = true;
      answer = d[v];
      break;
    }
    q.pop();
    pair<int, int> p1 = make_pair(v.first + 1, v.second);
    pair<int, int> p2 = make_pair(v.first - 1, v.second);
    pair<int, int> p3 = make_pair(v.first + 1, v.second + 1);
    pair<int, int> p4 = make_pair(v.first + 1, v.second - 1);
    pair<int, int> p5 = make_pair(v.first, v.second + 1);
    pair<int, int> p6 = make_pair(v.first, v.second - 1);
    pair<int, int> p7 = make_pair(v.first - 1, v.second - 1);
    pair<int, int> p8 = make_pair(v.first - 1, v.second + 1);
    if (binary_search(m[p1.first].begin(), m[p1.first].end(), p1.second) !=
        false) {
      if (!used[p1]) {
        used[p1] = true;
        q.push(p1);
        d[p1] = d[v] + 1;
      }
    }
    if (binary_search(m[p2.first].begin(), m[p2.first].end(), p2.second) !=
        false) {
      if (!used[p2]) {
        used[p2] = true;
        q.push(p2);
        d[p2] = d[v] + 1;
      }
    }
    if (binary_search(m[p3.first].begin(), m[p3.first].end(), p3.second) !=
        false) {
      if (!used[p3]) {
        used[p3] = true;
        q.push(p3);
        d[p3] = d[v] + 1;
      }
    }
    if (binary_search(m[p4.first].begin(), m[p4.first].end(), p4.second) !=
        false) {
      if (!used[p4]) {
        used[p4] = true;
        q.push(p4);
        d[p4] = d[v] + 1;
      }
    }
    if (binary_search(m[p5.first].begin(), m[p5.first].end(), p5.second) !=
        false) {
      if (!used[p5]) {
        used[p5] = true;
        q.push(p5);
        d[p5] = d[v] + 1;
      }
    }
    if (binary_search(m[p6.first].begin(), m[p6.first].end(), p6.second) !=
        false) {
      if (!used[p6]) {
        used[p6] = true;
        q.push(p6);
        d[p6] = d[v] + 1;
      }
    }
    if (binary_search(m[p7.first].begin(), m[p7.first].end(), p7.second) !=
        false) {
      if (!used[p7]) {
        used[p7] = true;
        q.push(p7);
        d[p7] = d[v] + 1;
      }
    }
    if (binary_search(m[p8.first].begin(), m[p8.first].end(), p8.second) !=
        false) {
      if (!used[p8]) {
        used[p8] = true;
        q.push(p8);
        d[p8] = d[v] + 1;
      }
    }
  }
}
int main() {
  int x1, y1, x2, y2;
  cin >> x1 >> y1 >> x2 >> y2;
  int n = 0;
  cin >> n;
  for (int i = 0; i < n; i++) {
    int r, a, b;
    cin >> r >> a >> b;
    for (int j = a; j <= b; j++) {
      m[r].push_back(j);
    }
    sort(m[r].begin(), m[r].end());
  }
  bfs(x1, y1, x2, y2);
  cout << answer;
  return 0;
}
