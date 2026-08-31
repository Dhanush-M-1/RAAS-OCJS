#include <bits/stdc++.h>
using namespace std;
map<long, vector<pair<long, long> > > mp;
int main() {
  long x0, y0, x1, y1;
  scanf("%ld %ld %ld %ld", &x0, &y0, &x1, &y1);
  long n;
  scanf("%ld", &n);
  long r, a, b;
  while (n--) {
    scanf("%ld %ld %ld", &r, &a, &b);
    mp[r].push_back(make_pair(a, b));
  }
  queue<pair<long, long> > q;
  map<pair<long, long>, bool> v;
  map<pair<long, long>, bool> p;
  map<pair<long, long>, long> l;
  l[make_pair(x0, y0)] = 0;
  l[make_pair(x1, y1)] = -1;
  q.push(make_pair(x0, y0));
  while (!q.empty()) {
    long ux = q.front().first;
    long uy = q.front().second;
    q.pop();
    if (v[make_pair(ux, uy)]) {
      continue;
    }
    v[make_pair(ux, uy)] = 1;
    long x[8] = {1, -1, 0, 0, 1, 1, -1, -1};
    long y[8] = {0, 0, 1, -1, 1, -1, -1, 1};
    for (int i = 0; i < 8; i++) {
      long adx = ux + x[i];
      long ady = uy + y[i];
      if (mp.find(adx) != mp.end()) {
        long n = mp[adx].size();
        for (long j = 0; j < n; j++) {
          long a = mp[adx][j].first;
          long b = mp[adx][j].second;
          if (ady >= a && ady <= b) {
            q.push(make_pair(adx, ady));
            if (l[make_pair(ux, uy)] + 1 < l[make_pair(adx, ady)] ||
                p[make_pair(adx, ady)] == 0) {
              l[make_pair(adx, ady)] = l[make_pair(ux, uy)] + 1;
              p[make_pair(adx, ady)] = 1;
              break;
            }
          }
        }
      }
    }
  }
  printf("%ld", l[make_pair(x1, y1)]);
  return 0;
}
