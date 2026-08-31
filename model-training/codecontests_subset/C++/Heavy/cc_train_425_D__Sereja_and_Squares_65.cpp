#include <bits/stdc++.h>
using namespace std;
const int inf = 1e9 + 5;
const long long linf = 1e18 + 5;
const int N = 1e5 + 5;
int n, x, y, ans;
pair<int, int> a[N];
vector<int> vx[N], vy[N];
int main() {
  ios ::sync_with_stdio(0);
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> a[i].first >> a[i].second;
    vx[a[i].first].push_back(a[i].second);
    vy[a[i].second].push_back(a[i].first);
  }
  for (int i = 0; i <= 100000; i++) {
    sort(vx[i].begin(), vx[i].end());
    sort(vy[i].begin(), vy[i].end());
  }
  for (int i = 1; i <= n; i++) {
    x = a[i].first;
    y = a[i].second;
    if (vx[x].size() < vy[y].size()) {
      for (__typeof((vx[x]).begin()) it = (vx[x]).begin(); it != (vx[x]).end();
           it++)
        if (*it > y)
          if (binary_search(vy[y].begin(), vy[y].end(), x + *it - y))
            if (binary_search(vy[*it].begin(), vy[*it].end(), x + *it - y))
              ans++;
    } else {
      for (__typeof((vy[y]).begin()) it = (vy[y]).begin(); it != (vy[y]).end();
           it++)
        if (*it > x)
          if (binary_search(vx[x].begin(), vx[x].end(), y + *it - x))
            if (binary_search(vx[*it].begin(), vx[*it].end(), y + *it - x))
              ans++;
    }
  }
  cout << ans << '\n';
  return 0;
}
