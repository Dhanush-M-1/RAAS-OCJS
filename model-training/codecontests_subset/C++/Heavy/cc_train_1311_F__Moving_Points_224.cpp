#include <bits/stdc++.h>
using namespace std;
const long long INF = 1e9 + 7;
const int N = 3e5 + 10;
void init(vector<pair<int, int>>& vp) {
  vector<int> v;
  for (auto& p : vp) v.push_back(p.second);
  sort(v.begin(), v.end());
  for (auto& p : vp) {
    p.second = lower_bound(v.begin(), v.end(), p.second) - v.begin() + 1;
  }
}
class BIT {
 public:
  long long a[N];
  void add(int x, long long val) {
    while (x < N) {
      a[x] += val;
      x += x & -x;
    }
  }
  long long sum(int x) {
    long long ret = 0;
    while (x) {
      ret += a[x];
      x -= x & -x;
    }
    return ret;
  }
} b1, b2;
int main() {
  int n;
  scanf("%d", &n);
  vector<pair<int, int>> vp(n);
  for (auto& p : vp) scanf("%d", &p.first);
  for (auto& p : vp) scanf("%d", &p.second);
  init(vp);
  long long ans = 0;
  sort(vp.begin(), vp.end());
  for (auto& p : vp) {
    b1.add(p.second, 1);
    b2.add(p.second, p.first);
    ans += b1.sum(p.second) * p.first - b2.sum(p.second);
  }
  printf("%lld\n", ans);
  return 0;
}
