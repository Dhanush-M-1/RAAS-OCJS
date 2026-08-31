#include <bits/stdc++.h>
using namespace std;
map<pair<long long, long long>, long long> allowed;
queue<pair<long long, long long> > q;
long long dx[] = {1, 1, 1, -1, -1, -1, 0, 0};
long long dy[] = {1, 0, -1, 1, 0, -1, 1, -1};
int main() {
  long long n, x0, y0, x1, y1, r, a, b;
  cin >> x0 >> y0 >> x1 >> y1;
  cin >> n;
  for (long long i = 0; i < n; i++) {
    cin >> r >> a >> b;
    for (long long j = a; j <= b; j++) {
      allowed[make_pair(r, j)] = -1;
    }
  }
  allowed[make_pair(x0, y0)] = 0;
  q.push(make_pair(x0, y0));
  while (!q.empty()) {
    pair<long long, long long> u = q.front();
    q.pop();
    for (long long i = 0; i < 8; i++) {
      pair<long long, long long> v =
          pair<long long, long long>(u.first + dx[i], u.second + dy[i]);
      if (allowed.count(v) && allowed[v] == -1) {
        allowed[v] = allowed[u] + 1;
        q.push(v);
      }
    }
  }
  cout << allowed[pair<long long, long long>(x1, y1)];
  return 0;
}
