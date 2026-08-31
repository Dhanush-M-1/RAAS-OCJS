#include <bits/stdc++.h>
using namespace std;
bool mark[100001];
int X[100001], Y[100001];
map<pair<int, long long>, int> mp;
int d[8][2] = {{0, 1}, {1, 0},  {0, -1}, {-1, 0},
               {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
int main() {
  pair<int, long long> s, e;
  cin >> s.first >> s.second >> e.first >> e.second;
  int n;
  cin >> n;
  for (int i = 0; i < n; ++i) {
    int r, a, b;
    cin >> r >> a >> b;
    for (int j = a; j <= b; ++j) {
      X[mp.size()] = r;
      Y[mp.size()] = j;
      mp.insert(make_pair(pair<int, long long>(r, j), mp.size()));
    }
  }
  memset(mark, false, sizeof mark);
  int t = mp[s], end = mp[e];
  queue<pair<int, long long> > q;
  q.push(pair<int, long long>(t, 0));
  mark[t] = true;
  long long ans = -1;
  while (!q.empty()) {
    t = q.front().first;
    long long dis = q.front().second;
    q.pop();
    if (t == end) ans = dis;
    for (int i = 0; i < 8; ++i) {
      int nx = X[t] + d[i][0], ny = Y[t] + d[i][1];
      pair<int, long long> nn = pair<int, long long>(nx, ny);
      if (mp.find(nn) != mp.end()) {
        int idx = mp[nn];
        if (mark[idx] == false) {
          q.push(pair<int, long long>(idx, dis + 1));
          mark[idx] = true;
        }
      }
    }
  }
  cout << ans << endl;
  return 0;
}
