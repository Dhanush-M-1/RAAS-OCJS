#include <bits/stdc++.h>
using namespace std;
int x, y, X, Y, n;
long long p = 1000000007ll;
map<long long, int> d;
vector<long long> g;
vector<long long>::iterator it;
int main() {
  int r, a, b;
  long long inf = p;
  scanf("%d %d %d %d\n", &x, &y, &X, &Y);
  scanf("%d\n", &n);
  for (int i = 0; i < n; i++) {
    scanf("%d %d %d\n", &r, &a, &b);
    for (int j = a; j <= b; j++) {
      g.push_back(r * 1ll * p + j);
      d[r * 1ll * p + j] = inf;
    }
  }
  sort(g.begin(), g.end());
  long long w = X * 1ll * p + Y, W[][2] = {{0, 1}, {0, -1}, {1, 0},  {1, -1},
                                           {1, 1}, {-1, 0}, {-1, 1}, {-1, -1}};
  d[w] = 0;
  priority_queue<pair<int, long long> > q;
  it = lower_bound(g.begin(), g.end(), w);
  if (*it == w) q.push(make_pair(0, X * p + Y));
  while (!q.empty()) {
    long long v = q.top().second, cur = -q.top().first;
    q.pop();
    if (cur > d[v]) continue;
    long long A = v / p, B = v % p;
    for (int j = 0; j < 8; j++) {
      w = (A + W[j][0]) * p + B + W[j][1];
      it = lower_bound(g.begin(), g.end(), w);
      if (*it == w) {
        if (d[v] + 1 < d[w]) {
          d[w] = d[v] + 1;
          q.push(make_pair(-d[w], w));
        }
      }
    }
  }
  w = x * 1ll * p + y;
  if (!d.count(w) || d[w] == inf) d[w] = -1;
  cout << d[w];
  return 0;
}
