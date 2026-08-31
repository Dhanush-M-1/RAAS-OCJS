#include <bits/stdc++.h>
using namespace std;
template <class T>
class BIT {
 private:
  vector<T> dat;
  int n;

 public:
  BIT(int _n) : dat(_n + 1), n(_n) {}
  T sum(int i) {
    T s = 0;
    while (i > 0) s += dat[i], i -= i & -i;
    return s;
  }
  T sum(int l, int r) { return l > r ? 0 : sum(r) - sum(l - 1); }
  void add(int i, T x) {
    while (i <= n) dat[i] += x, i += i & -i;
  }
};
int main() {
  cin.tie(0);
  ios::sync_with_stdio(false);
  int N;
  cin >> N;
  vector<pair<int64_t, int64_t>> P(N);
  for (auto &p : P) cin >> p.second;
  for (auto &p : P) cin >> p.first;
  sort(P.begin(), P.end());
  vector<int> vs;
  for (auto &p : P) vs.push_back(p.first);
  P[0].first = 1;
  for (int i = 1; i < N; ++i) {
    P[i].first = P[i - 1].first + (vs[i - 1] != vs[i]);
  }
  for (auto &p : P) swap(p.first, p.second);
  sort(P.begin(), P.end(), greater<pair<int, int>>());
  int64_t ans = 0LL;
  BIT<int64_t> bit(N), cnt(N);
  for (auto &p : P) {
    int x, v;
    tie(x, v) = p;
    ans += bit.sum(v, N) - x * cnt.sum(v, N);
    bit.add(v, x);
    cnt.add(v, 1);
  }
  cout << ans << '\n';
  return 0;
}
