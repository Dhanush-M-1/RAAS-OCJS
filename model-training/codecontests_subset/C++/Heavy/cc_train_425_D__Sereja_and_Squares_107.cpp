#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e5 + 10;
int x[maxn], y[maxn];
vector<int> xs[maxn], ys[maxn];
vector<pair<int, int> > al;
inline bool isin(int p, int q) {
  int pos = lower_bound(al.begin(), al.end(), make_pair(p, q)) - al.begin();
  return (pos < al.size() && al[pos] == make_pair(p, q));
}
int main() {
  ios::sync_with_stdio(0), cin.tie(0);
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> x[i] >> y[i];
    xs[x[i]].push_back(y[i]);
    ys[y[i]].push_back(x[i]);
    al.push_back({x[i], y[i]});
  }
  sort(al.begin(), al.end());
  for (int i = 0; i < maxn; i++)
    sort(xs[i].begin(), xs[i].end()), sort(ys[i].begin(), ys[i].end());
  int ans = 0;
  for (int i = 0; i < n; i++) {
    int p = x[i], q = y[i];
    int t1 = lower_bound(xs[p].begin(), xs[p].end(), q) - xs[p].begin();
    int t2 = lower_bound(ys[q].begin(), ys[q].end(), p) - ys[q].begin();
    int len1 = xs[p].size() - t1;
    int len2 = ys[q].size() - t2;
    if (len1 < len2) {
      for (int j = t1 + 1; j < xs[p].size(); j++) {
        int q2 = xs[p][j];
        ans += (isin(p + q2 - q, q) && isin(p + q2 - q, q2));
      }
    } else {
      for (int j = t2 + 1; j < ys[q].size(); j++) {
        int p2 = ys[q][j];
        ans += (isin(p, q + p2 - p) && isin(p2, q + p2 - p));
      }
    }
  }
  cout << ans << '\n';
}
