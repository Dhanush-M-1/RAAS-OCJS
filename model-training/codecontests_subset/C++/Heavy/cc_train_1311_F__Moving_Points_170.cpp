#include <bits/stdc++.h>
using namespace std;
template <class T>
bool uin(T& a, T b) {
  return a > b ? (a = b, true) : false;
}
template <class T>
bool uax(T& a, T b) {
  return a < b ? (a = b, true) : false;
}
template <typename T>
class fenwick {
 public:
  vector<T> fenw;
  int n;
  fenwick(int _n) : n(_n) { fenw.resize(n); }
  void modify(int x, T v) {
    while (x < n) {
      fenw[x] += v;
      x |= (x + 1);
    }
  }
  T get(int x) {
    T v{};
    while (x >= 0) {
      v += fenw[x];
      x = (x & (x + 1)) - 1;
    }
    return v;
  }
};
const int nax = 2e5 + 10;
int N;
vector<int> v;
vector<pair<int, int>> P;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> N;
  P.resize(N);
  v.resize(N);
  fenwick<long long> sum_tree(N), count_tree(N);
  for (int i = 0; i < N; ++i) {
    cin >> P[i].first;
  }
  for (int i = 0; i < N; ++i) {
    cin >> P[i].second;
    v[i] = P[i].second;
  }
  sort(v.begin(), v.end());
  v.resize(unique(v.begin(), v.end()) - v.begin());
  sort(P.begin(), P.end());
  long long total = 0;
  for (int i = 0; i < N; ++i) {
    int id = lower_bound(v.begin(), v.end(), P[i].second) - v.begin();
    long long count = count_tree.get(id);
    long long sum = sum_tree.get(id);
    total += count * 1LL * P[i].first - sum;
    count_tree.modify(id, 1);
    sum_tree.modify(id, P[i].first);
  }
  cout << total << '\n';
}
