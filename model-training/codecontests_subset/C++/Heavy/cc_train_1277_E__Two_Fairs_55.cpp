#include <bits/stdc++.h>
using namespace std;
ifstream in("input.in");
ofstream out("output.out");
const long long nmx = 2e5 + 5;
const long long MOD = 1e9 + 7;
long long n, m, a, b, cnt[nmx] = {};
bitset<nmx> vis;
vector<long long> li[nmx];
queue<long long> q;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long t;
  cin >> t;
  while (t--) {
    cin >> n >> m >> a >> b;
    for (int i = 1; i <= n; ++i) {
      li[i].clear();
      cnt[i] = 0;
    }
    vis.reset();
    for (int i = 1; i <= m; ++i) {
      long long x, y;
      cin >> x >> y;
      li[x].push_back(y);
      li[y].push_back(x);
    }
    q.push(a);
    while (!q.empty()) {
      long long f = q.front();
      q.pop();
      for (auto k : li[f]) {
        if (vis[k] == 0 && k != b && k != a) {
          ++cnt[k];
          vis[k] = 1;
          q.push(k);
        }
      }
    }
    vis.reset();
    q.push(b);
    while (!q.empty()) {
      long long f = q.front();
      q.pop();
      for (auto k : li[f]) {
        if (vis[k] == 0 && k != a && k != b) {
          ++cnt[k];
          vis[k] = 1;
          q.push(k);
        }
      }
    }
    long long fromA = 0;
    q.push(a);
    vis.reset();
    while (!q.empty()) {
      long long f = q.front();
      q.pop();
      for (auto k : li[f]) {
        if (vis[k] == 0 && cnt[k] == 1) {
          vis[k] = 1;
          q.push(k);
          ++fromA;
        }
      }
    }
    long long fromB = 0;
    q.push(b);
    vis.reset();
    while (!q.empty()) {
      long long f = q.front();
      q.pop();
      for (auto k : li[f]) {
        if (vis[k] == 0 && cnt[k] == 1) {
          vis[k] = 1;
          q.push(k);
          ++fromB;
        }
      }
    }
    cout << fromA * fromB << "\n";
  }
  return 0;
}
