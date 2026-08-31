#include <bits/stdc++.h>
using namespace std;
struct node {
  long long x, y;
  long long num;
};
queue<node> q;
long long stx, sty, n, xx, yy, fnx, fny, a, b, c, i, j;
long long ind, ans;
node k;
long long dx[8] = {0, 0, 1, 1, 1, -1, -1, -1};
long long dy[8] = {1, -1, 0, -1, 1, 1, 0, -1};
map<pair<long long, long long>, long long> m, fix;
int main() {
  scanf("%I64d %I64d %I64d %I64d", &stx, &sty, &fnx, &fny);
  scanf("%I64d", &n);
  for (i = 0; i < n; i++) {
    scanf("%I64d %I64d %I64d", &a, &b, &c);
    for (j = b; j <= c; j++) m[make_pair(a, j)] = 1;
  }
  q.push((node){stx, sty, 0});
  fix[make_pair(stx, sty)] = 1;
  ans = 1000000000;
  while (!q.empty()) {
    k = q.front();
    q.pop();
    fix[make_pair(xx, yy)] = 1;
    xx = k.x;
    yy = k.y;
    ind = k.num;
    if (xx == fnx && yy == fny) {
      ans = min(ans, ind);
      break;
    }
    for (i = 0; i < 8; i++)
      if (fix[make_pair(dx[i] + xx, dy[i] + yy)] != 1 &&
          m[make_pair(dx[i] + xx, dy[i] + yy)] == 1) {
        q.push((node){dx[i] + xx, dy[i] + yy, ind + 1});
        fix[make_pair(dx[i] + xx, dy[i] + yy)] = 1;
      }
  }
  if (ans == 1000000000)
    cout << -1 << endl;
  else
    cout << ans << endl;
}
