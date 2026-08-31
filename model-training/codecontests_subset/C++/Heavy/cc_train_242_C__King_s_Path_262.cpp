#include <bits/stdc++.h>
using namespace std;
struct point {
  long long int x;
  long long int y;
  bool operator<(const point p2) const {
    if (x != p2.x) {
      return x < p2.x;
    } else {
      return y < p2.y;
    }
  }
};
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  long long int x1, y1, x2, y2;
  cin >> x1 >> y1 >> x2 >> y2;
  long long int n;
  cin >> n;
  set<point> st;
  for (long long int i = 0; i < n; i++) {
    long long int r, a, b;
    cin >> r >> a >> b;
    for (long long int i = a; i <= b; i++) {
      st.insert({r, i});
    }
  }
  set<point> visited;
  queue<point> q;
  q.push({x1, y1});
  visited.insert({x1, y1});
  long long int moves = 0;
  vector<long long int> dx = {-1, -1, -1, 0, 0, 1, 1, 1};
  vector<long long int> dy = {-1, 0, 1, -1, 1, -1, 0, 1};
  long long int limit = 1e9;
  while (!q.empty()) {
    long long int size = q.size();
    while (size--) {
      point curr = q.front();
      q.pop();
      if (curr.x == x2 && curr.y == y2) {
        cout << moves;
        return 0;
      }
      for (long long int i = 0; i < 8; i++) {
        long long int X = curr.x + dx[i];
        long long int Y = curr.y + dy[i];
        if (X >= 1 && X <= limit && Y >= 1 && Y <= limit &&
            st.find({X, Y}) != st.end() &&
            visited.find({X, Y}) == visited.end()) {
          q.push({X, Y});
          visited.insert({X, Y});
        }
      }
    }
    moves++;
  }
  cout << -1;
  return 0;
}
