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
const int max_x = 100000000;
using It = vector<int>::iterator;
int64_t min_distance_sum(It begin, It end, It tmp_begin) {
  if (next(begin) == end) return 0;
  int64_t left_count = distance(begin, end) / 2;
  It mid = next(begin, left_count);
  const int64_t ans_left = min_distance_sum(begin, mid, tmp_begin);
  const int64_t ans_right =
      min_distance_sum(mid, end, next(tmp_begin, left_count));
  int64_t ans_cross = 0;
  It it1 = begin;
  It it2 = mid;
  It tmp = tmp_begin;
  int64_t left_sum = 0;
  while (it1 != mid && it2 != end) {
    if (*it1 < *it2) {
      left_sum += *it1;
      *tmp++ = *it1++;
    } else {
      ans_cross += static_cast<int64_t>(*it2) * distance(begin, it1) - left_sum;
      *tmp++ = *it2++;
    }
  }
  copy(it1, mid, tmp);
  while (it2 != end) {
    ans_cross += static_cast<int64_t>(*it2) * left_count - left_sum;
    *tmp++ = *it2++;
  }
  copy(tmp_begin, next(tmp_begin, distance(begin, end)), begin);
  return ans_left + ans_right + ans_cross;
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
  vector<int> x(n), tmp(n);
  for (int k = 0; k < (n); ++k) x[k] = data[k].second;
  cout << min_distance_sum(begin(x), end(x), tmp.begin()) << eol;
  return 0;
}
