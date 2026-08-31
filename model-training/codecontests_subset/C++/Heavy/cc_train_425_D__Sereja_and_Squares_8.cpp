#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e5 + 100;
long long int n, ans;
pair<int, int> po[maxn];
vector<pair<int, int>> sa[maxn], so[maxn];
int main() {
  scanf("%lld", &n);
  for (int i = 0; i < n; i++) {
    int x, y;
    scanf("%d %d", &x, &y);
    po[i] = {x, y};
    sa[x].push_back({x, y});
    so[y].push_back({x, y});
  }
  sort(po, po + n);
  for (int i = 0; i < n; i++) {
    if (sa[po[i].first].size() <= so[po[i].second].size()) {
      for (auto u : sa[po[i].first]) {
        if (u.second > po[i].second) {
          pair<int, int> go3 = {po[i].first + u.second - po[i].second,
                                po[i].second},
                         go4 = {po[i].first + u.second - po[i].second,
                                u.second};
          if (binary_search(po, po + n, go3) == 1 and
              binary_search(po, po + n, go4) == 1) {
            ans++;
          }
        }
      }
    } else {
      for (auto u : so[po[i].second]) {
        if (u.first > po[i].first) {
          pair<int, int> go3 = {po[i].first,
                                po[i].second + u.first - po[i].first},
                         go4 = {u.first, po[i].second + u.first - po[i].first};
          if (binary_search(po, po + n, go3) == 1 and
              binary_search(po, po + n, go4) == 1) {
            ans++;
          }
        }
      }
    }
  }
  cout << ans;
}
