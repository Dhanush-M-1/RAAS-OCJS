#include <bits/stdc++.h>
using namespace std;
const long long MAXN = 1e5 + 4;
vector<long long> vx[MAXN];
vector<long long> vy[MAXN];
long long hash1(long long x, long long y) { return x + y * MAXN; }
unordered_set<long long> s;
long long n, x, y;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> n;
  long long cnt = 0;
  for (long long i = 0; i < n; i++) {
    cin >> x >> y;
    if (vx[x].size() < vy[y].size()) {
      for (long long j = 0; j < vx[x].size(); j++) {
        long long t = abs(vx[x][j] - y);
        if (s.find(hash1(x + t, y)) != s.end() &&
            s.find(hash1(x + t, vx[x][j])) != s.end())
          cnt++;
        if (s.find(hash1(x - t, y)) != s.end() &&
            s.find(hash1(x - t, vx[x][j])) != s.end())
          cnt++;
      }
    } else {
      for (long long j = 0; j < vy[y].size(); j++) {
        long long t = abs(vy[y][j] - x);
        if (s.find(hash1(x, y + t)) != s.end() &&
            s.find(hash1(vy[y][j], y + t)) != s.end())
          cnt++;
        if (s.find(hash1(x, y - t)) != s.end() &&
            s.find(hash1(vy[y][j], y - t)) != s.end())
          cnt++;
      }
    }
    s.insert(hash1(x, y));
    vx[x].push_back(y);
    vy[y].push_back(x);
  }
  cout << cnt << endl;
  return 0;
}
