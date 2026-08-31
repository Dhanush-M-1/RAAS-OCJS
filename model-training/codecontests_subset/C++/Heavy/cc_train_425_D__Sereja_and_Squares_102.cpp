#include <bits/stdc++.h>
using namespace std;
const int MN = 1e5 + 10;
vector<int> hor[MN];
vector<int> ver[MN];
vector<pair<int, int> > crd;
unordered_map<int, int> t[MN];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int n;
  cin >> n;
  crd.resize(n);
  for (int i = 0; i < n; ++i) {
    int x, y;
    cin >> x >> y;
    crd[i] = {x, y};
    t[x][y] = 1;
    hor[y].push_back(x);
    ver[x].push_back(y);
  }
  for (int i = 0; i < MN; ++i) {
    sort(hor[i].begin(), hor[i].end());
    sort(ver[i].begin(), ver[i].end());
  }
  int ans = 0;
  for (int i = 0; i < n; ++i) {
    int x = crd[i].first;
    int y = crd[i].second;
    vector<int>::iterator it1 = upper_bound(hor[y].begin(), hor[y].end(), x);
    vector<int>::iterator it2 = upper_bound(ver[x].begin(), ver[x].end(), y);
    if (distance(it1, hor[y].end()) < distance(it2, ver[x].end())) {
      for (; it1 != hor[y].end(); ++it1) {
        int q = *it1 - x;
        if (t[x][y + q] && t[x + q][y + q]) {
          ++ans;
        }
      }
    } else {
      for (; it2 != ver[x].end(); ++it2) {
        int q = *it2 - y;
        if (t[x + q][y] && t[x + q][y + q]) ++ans;
      }
    }
  }
  cout << ans << '\n';
}
