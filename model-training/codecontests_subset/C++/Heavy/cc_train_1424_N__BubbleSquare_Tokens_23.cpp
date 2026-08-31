#include <bits/stdc++.h>
using namespace std;
const int Inf = 0x3f3f3f3f;
const long long INF = 0x3f3f3f3f3f3f3f3fll;
int n, k;
int u[1 << 20], v[1 << 20];
bool sel[1 << 14];
vector<pair<int, int> > nei[1 << 14], egs[1 << 14];
bool lgl[1 << 21];
int val[1 << 20], F[1 << 20];
int main() {
  scanf("%d%d", &n, &k);
  for (int i = 1; i <= (k); ++i) {
    int a, b;
    scanf("%d%d", &a, &b);
    u[i] = a;
    v[i] = b;
    if (a < b) swap(a, b);
    nei[a].push_back(make_pair(b, i));
    egs[a].push_back(make_pair(b, i));
    egs[b].push_back(make_pair(a, i));
    val[i] = 1;
  }
  for (int i = 1; i <= (n); ++i) {
    int fix = 0;
    for (int j = 0; j < (((int)(nei[i]).size())); ++j) {
      int to = nei[i][j].first, eg = nei[i][j].second;
      if (sel[to]) {
        sel[to] = 0;
        ++val[eg];
      }
    }
    for (int j = 0; j < (((int)(egs[i]).size())); ++j)
      fix += val[egs[i][j].second];
    for (int j = (fix - ((int)(nei[i]).size())); j <= (fix); ++j) lgl[j] = 0;
    for (int j = 0; j < (((int)(nei[i]).size())); ++j)
      lgl[F[nei[i][j].first]] = 1;
    for (int j = 0; j < (((int)(nei[i]).size())); ++j) {
      int to = nei[i][j].first, eg = nei[i][j].second;
      if (lgl[fix]) {
        sel[to] = 1;
        --val[eg];
        --fix;
      } else {
        break;
      }
    }
    F[i] = fix;
  }
  int all = 0;
  for (int i = 1; i <= (n); ++i) all += sel[i];
  printf("%d\n", all);
  for (int i = 1; i <= (n); ++i)
    if (sel[i]) printf("%d\n", i);
  for (int i = 1; i <= (k); ++i) printf("%d %d %d\n", u[i], v[i], val[i]);
  return 0;
}
