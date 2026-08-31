#include <bits/stdc++.h>
using namespace std;
namespace my {
const int SIZE = 100001;
int x0, y0, x1, y1;
int n;
int R[SIZE], A[SIZE], B[SIZE];
set<pair<int, int> > F;
void init() { F.clear(); }
bool input() {
  if (!(cin >> x0 >> y0 >> x1 >> y1)) return false;
  cin >> n;
  for (int i = 0; i < n; ++i) {
    cin >> R[i] >> A[i] >> B[i];
  }
  return true;
}
priority_queue<pair<int, pair<int, int> >, vector<pair<int, pair<int, int> > >,
               greater<pair<int, pair<int, int> > > >
    Q;
set<pair<int, int> > V;
const int dr[8] = {0, 0, 1, -1, 1, 1, -1, -1};
const int dc[8] = {1, -1, 0, 0, 1, -1, 1, -1};
void dijkstra_init() {
  Q = priority_queue<pair<int, pair<int, int> >,
                     vector<pair<int, pair<int, int> > >,
                     greater<pair<int, pair<int, int> > > >();
  V.clear();
}
bool check_state(pair<int, int> state) {
  set<pair<int, int> >::iterator it_begin =
      F.lower_bound(pair<int, int>(state.first, -1));
  for (set<pair<int, int> >::iterator it_i = it_begin; it_i != F.end();
       ++it_i) {
    int r = (*it_i).first;
    int k = (*it_i).second;
    if (r != state.first) break;
    int a = A[k];
    int b = B[k];
    if (a <= state.second && state.second <= b) {
      return true;
    }
  }
  return false;
}
bool check_visited(pair<int, int> state) {
  if (V.count(state)) return false;
  V.insert(state);
  return true;
}
int dijkstra(pair<int, int> start_cell, pair<int, int> goal_cell) {
  dijkstra_init();
  pair<int, int> start_state(start_cell);
  pair<int, pair<int, int> > start_node(0, start_state);
  Q.push(start_node);
  while (!Q.empty()) {
    pair<int, pair<int, int> > node = Q.top();
    Q.pop();
    int steps = node.first;
    int r = node.second.first;
    int c = node.second.second;
    if (r == goal_cell.first && c == goal_cell.second) {
      return steps;
    }
    for (int i = 0; i < 8; ++i) {
      int next_steps = steps + 1;
      int nr = r + dr[i];
      int nc = c + dc[i];
      pair<int, int> next_state(nr, nc);
      if (!check_state(next_state)) {
        continue;
      }
      if (!check_visited(next_state)) {
        continue;
      }
      pair<int, pair<int, int> > next_node(next_steps, next_state);
      Q.push(next_node);
    }
  }
  return -1;
}
void solve_init() {
  for (int i = 0; i < n; ++i) {
    F.insert(pair<int, int>(R[i], i));
  }
}
int solve() {
  solve_init();
  return dijkstra(pair<int, int>(x0, y0), pair<int, int>(x1, y1));
}
}  // namespace my
int main() {
  while (my::init(), my::input()) {
    cout << my::solve() << endl;
  }
  return 0;
}
