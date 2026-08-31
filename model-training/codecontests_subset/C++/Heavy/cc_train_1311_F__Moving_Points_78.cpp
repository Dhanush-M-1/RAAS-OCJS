#include <bits/stdc++.h>
using namespace std;
const long long N = 1e5 + 7;
int n;
vector<pair<int, int>> p;
vector<int> vv1;
long long get(vector<long long> &f, int pos) {
  long long res = 0;
  for (; pos >= 0; pos = (pos & (pos + 1)) - 1) {
    res += f[pos];
  }
  return res;
}
void upd(vector<long long> &f, int pos, int val) {
  for (; pos < f.size(); pos |= pos + 1) f[pos] += val;
}
int main() {
  scanf("%d", &n);
  p.resize(n);
  for (int i = 0; i < n; i++) scanf("%d", &p[i].first);
  for (int i = 0; i < n; i++) {
    scanf("%d", &p[i].second);
    vv1.push_back(p[i].second);
  }
  sort(vv1.begin(), vv1.end());
  vv1.resize(unique(vv1.begin(), vv1.end()) - vv1.begin());
  sort(p.begin(), p.end());
  long long ans = 0;
  vector<long long> tmpv1(vv1.size()), tmpv2(vv1.size());
  for (int i = 0; i < n; i++) {
    int pos = lower_bound(vv1.begin(), vv1.end(), p[i].second) - vv1.begin();
    ans += get(tmpv1, pos) * 1ll * p[i].first - get(tmpv2, pos);
    upd(tmpv1, pos, 1);
    upd(tmpv2, pos, p[i].first);
  }
  printf("%lld\n", ans);
  return 0;
}
