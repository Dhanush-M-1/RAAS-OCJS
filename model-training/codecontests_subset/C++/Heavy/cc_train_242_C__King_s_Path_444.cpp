#include <bits/stdc++.h>
using namespace std;
const int maxn = 100000 + 5;
const int INF = (int)1e9 + 7;
const double EPS = 1e-9;
const int hh[] = {1, -1, 0, 0, -1, -1, 1, 1};
const int hc[] = {0, 0, 1, -1, -1, 1, -1, 1};
void nhap();
void process();
int n, k, y;
set<pair<int, int> > th;
queue<pair<int, pair<int, int> > > hd;
int s1, s2, e1, e2;
int res;
int main() {
  int nTest = 1;
  for (int test = 1; test <= nTest; ++test) {
    nhap();
    process();
  }
}
void nhap() {
  scanf("%d%d%d%d", &s1, &s2, &e1, &e2);
  scanf("%d", &n);
  int r, ai, bi;
  for (int i = 1; i <= n; ++i) {
    scanf("%d%d%d", &r, &ai, &bi);
    for (int j = ai; j <= bi; ++j) th.insert(make_pair(r, j));
  }
}
void process() {
  hd.push(make_pair(0, make_pair(s1, s2)));
  th.erase(pair<int, int>(s1, s2));
  int y, x, p, q, ts;
  while (!hd.empty()) {
    pair<int, pair<int, int> > u = hd.front();
    hd.pop();
    ts = u.first;
    x = u.second.first;
    y = u.second.second;
    for (int i = 0; i < 8; ++i) {
      p = x + hh[i];
      q = y + hc[i];
      pair<int, int> ii = make_pair(p, q);
      if (th.count(ii) > 0) {
        if (p == e1 && q == e2) {
          printf("%d", ts + 1);
          return;
        }
        th.erase(ii);
        hd.push(make_pair(ts + 1, ii));
      }
    }
  }
  puts("-1");
}
