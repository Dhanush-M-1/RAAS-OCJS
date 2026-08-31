#include <bits/stdc++.h>
using namespace std;
map<pair<long long, long long>, long long> allowed;
map<pair<long long, long long>, long long> marked;
long long dr[] = {1, 1, 1, 0, 0, -1, -1, -1};
long long dc[] = {1, -1, 0, 1, -1, 0, -1, 1};
long long bfs(long long sr, long long sc, long long er, long long ec) {
  queue<pair<long long, long long> > q;
  q.push(make_pair(sr, sc));
  marked[make_pair(sr, sc)] = 0;
  pair<long long, long long> p;
  while (!q.empty()) {
    p = q.front();
    q.pop();
    for (long long i = 0; i < 8; ++i) {
      long long tr = p.first + dr[i];
      long long tc = p.second + dc[i];
      if (tr > 1e9 || tc > 1e9 || tr < 1 || tc < 1 ||
          !(allowed[make_pair(tr, tc)] > 0) || marked[make_pair(tr, tc)] > 0)
        continue;
      marked[make_pair(tr, tc)] = marked[p] + 1;
      if (tr == er && tc == ec) {
        return marked[p] + 1;
      }
      q.push(make_pair(tr, tc));
    }
  }
  return -1;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long sr, se, er, ee;
  cin >> sr >> se >> er >> ee;
  long long n;
  cin >> n;
  long long row, col1, col2;
  for (long long i = 0; i < n; ++i) {
    cin >> row >> col1 >> col2;
    for (long long j = col1; j < col2 + 1; ++j) {
      allowed[make_pair(row, j)] = 1;
    }
  }
  long long ans = bfs(sr, se, er, ee);
  cout << ans << '\n';
}
