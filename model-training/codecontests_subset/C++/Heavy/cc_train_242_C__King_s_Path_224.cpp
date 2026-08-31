#include <bits/stdc++.h>
using namespace std;
long long int Mod = 100000000;
map<pair<long long int, long long int>, int> hmp;
queue<pair<long long int, long long int> > Q;
map<pair<long long int, long long int>, long long int> visited;
int main() {
  long long int i, j, k, l, m, n, x, y, z, a, b, r, t, x0, y0, x1, y1,
      a1 = 0, a2 = 0, a3 = 0;
  scanf("%lld", &x0);
  scanf("%lld", &y0);
  scanf("%lld", &x1);
  scanf("%lld", &y1);
  scanf("%lld", &n);
  for (i = 0; i < n; i++) {
    scanf("%lld", &r);
    scanf("%lld", &a);
    scanf("%lld", &b);
    for (j = a; j <= b; j++) {
      hmp[make_pair(r, j)] = 1;
    }
  }
  Q.push(make_pair(x0, y0));
  visited[make_pair(x0, y0)] = 1;
  long long int ans = 0;
  while (!Q.empty()) {
    pair<long long int, long long int> p = Q.front();
    Q.pop();
    a3 = 0;
    for (i = -1; i < 2; i++) {
      for (j = -1; j < 2; j++) {
        x = p.first + i;
        y = p.second + j;
        if (hmp[make_pair(x, y)] == 1) {
          if (!visited[make_pair(x, y)]) {
            visited[make_pair(x, y)] = visited[p] + 1;
            Q.push(make_pair(x, y));
          }
        }
        if (hmp[make_pair(x, y)] != 1) {
          continue;
        }
      }
    }
  }
  if (!visited[make_pair(x1, y1)]) {
    printf("-1\n");
    return 0;
  }
  printf("%lld\n", visited[make_pair(x1, y1)] - 1);
  return 0;
}
