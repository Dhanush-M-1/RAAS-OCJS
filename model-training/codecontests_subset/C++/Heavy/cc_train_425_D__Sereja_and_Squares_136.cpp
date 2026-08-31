#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 5;
const int mod = 1e9 + 7;
const int inf = 1e9 + 7;
int n, i, x, y, t1, t2, b, k, t3, t4, ans, j;
pair<int, int> a[N];
vector<int> sat[N], sut[N];
int main() {
  scanf("%d", &n);
  for (i = 1; i <= n; i++) {
    scanf("%d %d", &x, &y);
    sat[y].push_back(x);
    sut[x].push_back(y);
    a[i] = make_pair(x, y);
  }
  for (i = 0; i <= N - 5; i++)
    sort(sat[i].begin(), sat[i].end()), sort(sut[i].begin(), sut[i].end());
  for (i = 1; i <= n; i++) {
    x = a[i].first;
    y = a[i].second;
    t1 = lower_bound(sat[y].begin(), sat[y].end(), x) - sat[y].begin();
    t2 = lower_bound(sut[x].begin(), sut[x].end(), y) - sut[x].begin();
    if (sat[y].size() - t1 <= sut[x].size() - t2) {
      for (j = t1 + 1; j < sat[y].size(); j++) {
        b = sat[y][j];
        k = b - x;
        t3 = lower_bound(sut[x].begin(), sut[x].end(), y + k) - sut[x].begin();
        t4 = lower_bound(sut[b].begin(), sut[b].end(), y + k) - sut[b].begin();
        if (t3 < sut[x].size() and t4 < sut[b].size() and
            sut[x][t3] == y + k and sut[b][t4] == y + k)
          ans++;
      }
    } else {
      for (j = t2 + 1; j < sut[x].size(); j++) {
        b = sut[x][j];
        k = b - y;
        t3 = lower_bound(sat[y].begin(), sat[y].end(), x + k) - sat[y].begin();
        t4 = lower_bound(sat[b].begin(), sat[b].end(), x + k) - sat[b].begin();
        if (t3 < sat[y].size() and t4 < sat[b].size() and
            sat[y][t3] == x + k and sat[b][t4] == x + k)
          ans++;
      }
    }
  }
  cout << ans << endl;
}
