#include <bits/stdc++.h>
using namespace std;
const int MOD = 998244353;
const long long INF = 1e18;
const int MX = 1e9;
set<pair<int, int> > pool;
map<pair<int, int>, int> m;
pair<int, int> st, ed;
int N, R, A, B;
int dx[8] = {1, 0, -1, 1, -1, 1, 0, -1};
int dy[8] = {1, 1, 1, 0, 0, -1, -1, -1};
int main() {
  cin.sync_with_stdio(0);
  cin.tie(0);
  cin >> st.first >> st.second >> ed.first >> ed.second;
  cin >> N;
  for (int i = (0); i < (N); ++i) {
    cin >> R >> A >> B;
    for (int j = (A); j < (B + 1); ++j) pool.insert(make_pair(R, j));
  }
  for (auto& iter : pool) m[iter] = -1;
  queue<pair<int, int> > q;
  while (!q.empty()) q.pop();
  q.push(st);
  m[st] = 0;
  while (!q.empty()) {
    pair<int, int> curr = q.front();
    q.pop();
    for (int i = (0); i < (8); ++i) {
      int x = curr.first + dx[i], y = curr.second + dy[i];
      pair<int, int> to = make_pair(x, y);
      if (m[to] == -1) {
        m[to] = m[curr] + 1;
        q.push(to);
      }
    }
  }
  cout << m[ed];
  return 0;
}
