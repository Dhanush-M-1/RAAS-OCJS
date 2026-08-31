#include <bits/stdc++.h>
#pragma GCC optimize "O3"
using namespace std;
const int inf = 0x3f3f3f3f;
const long long INF = 0x3f3f3f3f3f3f3f3f;
const int N = 1e5 + 5;
int n, a, b, ans;
vector<int> xy[N], yx[N];
vector<pair<int, int> > pnt;
bool jest(pair<int, int> pkt) {
  return pnt[lower_bound(pnt.begin(), pnt.end(), pkt) - pnt.begin()] == pkt;
}
bool checkx(pair<int, int> pkt1, pair<int, int> pkt2) {
  int bok = pkt2.second - pkt1.second;
  return jest({pkt1.first + bok, pkt1.second}) &&
         jest({pkt2.first + bok, pkt2.second});
}
bool checky(pair<int, int> pkt1, pair<int, int> pkt2) {
  int bok = pkt2.first - pkt1.first;
  return jest({pkt1.first, pkt1.second + bok}) &&
         jest({pkt2.first, pkt2.second + bok});
}
void solve() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> a >> b;
    xy[a].push_back(b);
    yx[b].push_back(a);
    pnt.push_back({a, b});
  }
  pnt.push_back({inf, inf});
  sort(pnt.begin(), pnt.end());
  for (int i = 0; i <= N - 1; i++) {
    sort(xy[i].begin(), xy[i].end());
    sort(yx[i].begin(), yx[i].end());
  }
  for (auto &cor : pnt) {
    if (cor == make_pair(inf, inf)) continue;
    if (((int)xy[cor.first].size()) < ((int)yx[cor.second].size())) {
      for (int y = lower_bound(xy[cor.first].begin(), xy[cor.first].end(),
                               cor.second) -
                   xy[cor.first].begin() + 1;
           y < ((int)xy[cor.first].size()); y++) {
        ans += checkx(cor, {cor.first, xy[cor.first][y]});
      }
    } else {
      for (int y = lower_bound(yx[cor.second].begin(), yx[cor.second].end(),
                               cor.first) -
                   yx[cor.second].begin() + 1;
           y < ((int)yx[cor.second].size()); y++) {
        ans += checky(cor, {yx[cor.second][y], cor.second});
      }
    }
  }
  cout << ans << '\n';
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  solve();
  return 0;
}
