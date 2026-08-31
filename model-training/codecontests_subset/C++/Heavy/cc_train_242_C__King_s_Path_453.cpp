#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false), cin.tie(NULL);
  clock_t clk = clock();
  cerr << "ACE THE GAME ...\n";
  map<pair<long long, long long>, long long> allowed;
  queue<pair<long long, long long> > q;
  long long dx[] = {1, 1, 1, -1, -1, -1, 0, 0};
  long long dy[] = {1, 0, -1, 1, 0, -1, 1, -1};
  long long n, x0, y0, x1, y1, r, a, b;
  cin >> x0 >> y0 >> x1 >> y1;
  cin >> n;
  for (long long i = 0; i < n; i++) {
    cin >> r >> a >> b;
    for (long long j = a; j <= b; j++) {
      allowed[make_pair(r, j)] = -1;
    }
  }
  allowed[pair<long long, long long>(x0, y0)] = 0;
  q.push(make_pair(x0, y0));
  while (!q.empty()) {
    pair<long long, long long> u = q.front();
    q.pop();
    for (long long i = 0; i < 8; i++) {
      pair<long long, long long> v =
          pair<long long, long long>(u.first + dx[i], u.second + dy[i]);
      if (allowed[v] == -1) {
        allowed[v] = allowed[u] + 1;
        q.push(v);
      }
    }
  }
  cout << allowed[pair<long long, long long>(x1, y1)];
  cerr << "...and TAKE IT EASY.\n";
  cerr << "Time (in ms): " << double(clock() - clk) * 1000.0 / CLOCKS_PER_SEC
       << '\n';
}
