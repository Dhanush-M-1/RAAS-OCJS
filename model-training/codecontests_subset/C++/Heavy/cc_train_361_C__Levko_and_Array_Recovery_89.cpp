#include <bits/stdc++.h>
using namespace std;
int least[5005];
int val[5005];
vector<pair<pair<int, int>, pair<int, int> > > vec;
int main() {
  srand((unsigned int)time(NULL));
  int n, m;
  scanf("%d%d", &n, &m);
  fill(least, least + 5005, 1000000000);
  for (int i = 1; i <= m; i++) {
    int x;
    scanf("%d", &x);
    int l, r, v;
    if (x == 1) {
      scanf("%d%d%d", &l, &r, &v);
      for (int j = l; j <= r; j++) val[j] += v;
    } else {
      scanf("%d%d%d", &l, &r, &v);
      for (int j = l; j <= r; j++) {
        least[j] = min(least[j], v - val[j]);
      }
    }
    vec.push_back(make_pair(make_pair(x, l), make_pair(r, v)));
  }
  memset(val, 0, sizeof(val));
  for (int i = 0; i < m; i++) {
    int x = vec[i].first.first;
    int l = vec[i].first.second;
    int r = vec[i].second.first;
    int v = vec[i].second.second;
    if (x == 1) {
      scanf("%d%d%d", &l, &r, &v);
      for (int j = l; j <= r; j++) val[j] += v;
    } else {
      bool ok = false;
      for (int j = l; j <= r; j++) {
        if (val[j] + least[j] > v) {
          ok = 0;
          break;
        }
        if (val[j] + least[j] == v) ok = 1;
      }
      if (!ok) {
        puts("NO");
        return 0;
      }
    }
  }
  puts("YES");
  for (int i = 1; i <= n; i++) printf("%d%c", least[i], i == n ? '\n' : ' ');
}
