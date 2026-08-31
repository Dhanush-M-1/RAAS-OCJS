#include <bits/stdc++.h>
using namespace std;
inline int lowbit(int x) { return x & (-x); }
long long getsum(vector<long long> &V, int pos) {
  long long ret = 0;
  for (; pos; pos -= lowbit(pos)) ret += V[pos];
  return ret;
}
void add(vector<long long> &V, int pos, int k) {
  for (; pos < (int)V.size(); pos += lowbit(pos)) V[pos] += k;
}
int main() {
  int n;
  cin >> n;
  vector<pair<int, int>> p(n);
  for (auto &pnt : p) {
    int x;
    scanf("%d", &x);
    pnt.first = x;
  }
  for (auto &pnt : p) {
    int v;
    scanf("%d", &v);
    pnt.second = v;
  }
  sort(p.begin(), p.end());
  vector<int> vs{(int)(-1e9)};
  for (auto pnt : p) vs.push_back(pnt.second);
  sort(vs.begin(), vs.end());
  vs.resize(unique(vs.begin(), vs.end()) - vs.begin());
  long long ans = 0;
  vector<long long> cnt(vs.size()), xs(vs.size());
  for (auto pnt : p) {
    int pos = lower_bound(vs.begin(), vs.end(), pnt.second) - vs.begin();
    ans += getsum(cnt, pos) * pnt.first - getsum(xs, pos);
    add(cnt, pos, 1), add(xs, pos, pnt.first);
  }
  printf("%lld\n", ans);
}
