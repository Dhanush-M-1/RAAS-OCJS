#include <bits/stdc++.h>
template <class C>
inline void log_c(const C& c) {}
template <class C>
inline int sz(const C& c) {
  return static_cast<int>(c.size());
}
using namespace std;
using pii = pair<int, int>;
using num = int64_t;
using pll = pair<num, num>;
const std::string eol = "\n";
using Ft = map<int, pair<int, int64_t>>;
const int max_x = 100000000;
void ft_inc(Ft& ft, int x, const pair<int, int64_t>& p) {
  for (; x <= max_x; x |= x + 1) {
    ft[x].first += p.first;
    ft[x].second += p.second;
  }
}
pair<int, int64_t> ft_sum(Ft& ft, int x) {
  pair<int, int64_t> res;
  for (; x >= 0; x = (x & (x + 1)) - 1) {
    res.first += ft[x].first;
    res.second += ft[x].second;
  }
  return res;
}
int main() {
  std::ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  int n;
  cin >> n;
  vector<pii> data(n);
  for (int k = 0; k < (n); ++k) cin >> data[k].second;
  for (int k = 0; k < (n); ++k) cin >> data[k].first;
  sort(begin(data), end(data));
  Ft ft_slow;
  int64_t ans = 0;
  for (int k = 0; k < (sz(data)); ++k) {
    const auto [v, x] = data[k];
    const auto [c_slow, s_slow] = ft_sum(ft_slow, x);
    ans += static_cast<int64_t>(x) * c_slow - s_slow;
    ft_inc(ft_slow, x, {1, x});
  }
  cout << ans << eol;
  return 0;
}
