#include <bits/stdc++.h>
using namespace std;
const int N = 12500, M = 1000000;
int n, m;
vector<pair<int, int> > nei[N + 1];
int a[M + 1], b[M + 1];
int ansv[N + 1], anse[M + 1];
int val[N + 1];
bool hav[2 * M + N + 1];
int main() {
  cin >> n >> m;
  for (int i = 1; i <= m; i++) {
    int x, y;
    scanf("%d%d", &x, &y);
    a[i] = x, b[i] = y;
    nei[x].push_back(make_pair(y, i));
    nei[y].push_back(make_pair(x, i));
    anse[i] = 1;
  }
  for (int i = 1; i <= n; i++) {
    int dec = 0;
    for (int j = 0; j < nei[i].size(); j++) {
      int x = nei[i][j].first;
      if (x < i) hav[val[x]] = true;
      if (x < i && !ansv[x]) dec++;
    }
    for (int j = nei[i].size() - dec;; j++)
      if (!hav[j]) {
        val[i] = j;
        break;
      }
    int now = val[i] - nei[i].size();
    for (int j = 0; j < nei[i].size(); j++) {
      int x = nei[i][j].first, y = nei[i][j].second;
      if (x < i) hav[val[x]] = false;
      if (x < i && !ansv[x] && now < 0) now++, ansv[x]++, anse[y]--;
      if (x < i && ansv[x] && now > 0) now--, ansv[x]--, anse[y]++;
    }
  }
  vector<int> v;
  for (int i = 1; i <= n; i++)
    if (ansv[i]) v.push_back(i);
  cout << v.size() << "\n";
  for (int i = 0; i < v.size(); i++) cout << v[i] << " \n"[i + 1 == v.size()];
  for (int i = 1; i <= m; i++) printf("%d %d %d\n", a[i], b[i], anse[i]);
  return 0;
}
