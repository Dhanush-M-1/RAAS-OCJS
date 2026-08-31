#include <bits/stdc++.h>
using namespace std;
using ll = long long;
template <int n, class... T>
typename enable_if<(n >= sizeof...(T))>::type _ot(ostream &,
                                                  tuple<T...> const &) {}
template <int n, class... T>
typename enable_if<(n < sizeof...(T))>::type _ot(ostream &os,
                                                 tuple<T...> const &t) {
  os << (n == 0 ? "" : ", ") << get<n>(t);
  _ot<n + 1>(os, t);
}
template <class... T>
ostream &operator<<(ostream &o, tuple<T...> const &t) {
  o << "(";
  _ot<0>(o, t);
  o << ")";
  return o;
}
template <class T, class U>
ostream &operator<<(ostream &o, pair<T, U> const &p) {
  o << "(" << p.first << ", " << p.second << ")";
  return o;
}
template <class T,
          class = typename iterator_traits<typename T::iterator>::value_type,
          class = typename enable_if<!is_same<T, string>::value>::type>
ostream &operator<<(ostream &o, const T &a) {
  for (auto ite = a.begin(); ite != a.end(); ++ite)
    o << (ite == a.begin() ? "" : " ") << *ite;
  return o;
}
const int N = 2e5;
vector<pair<int, int>> g[N];
int main() {
  std::ios::sync_with_stdio(false), std::cin.tie(0);
  ll n, m, k;
  cin >> n >> m >> k;
  vector<pair<int, int>> v;
  vector<int> fri(n);
  vector<int> vfri(n);
  for (int i = 0; i < m; i++) {
    int a, b;
    cin >> a >> b;
    a--;
    b--;
    v.emplace_back(a, b);
    g[a].emplace_back(b, i);
    g[b].emplace_back(a, i);
    fri[a]++;
    fri[b]++;
    vfri[a]++;
    vfri[b]++;
  }
  vector<int> no(n);
  int col = 1;
  vector<int> used(n);
  ll now = n;
  int tim = m - 1;
  function<void(int)> check = [&](int i) {
    if (no[i]) return;
    if (vfri[i] < k) {
      no[i] = 1;
      now--;
      auto ng = g[i];
      ng.clear();
      for (auto p : g[i]) {
        int j, t;
        tie(j, t) = p;
        if (t > tim) continue;
        ng.emplace_back(j, t);
        if (!no[j]) {
          vfri[j]--;
          check(j);
        }
      }
      g[i] = ng;
    }
  };
  for (int i = 0; i < n; i++)
    if (!no[i]) check(i);
  vector<int> ans(m);
  for (int i = m - 1; i >= 0; i--) {
    tim--;
    ans[i] = now;
    if (i == 0) break;
    int a, b;
    tie(a, b) = v[i];
    fri[a]--;
    fri[b]--;
    if (!no[a]) vfri[b]--;
    if (!no[b]) vfri[a]--;
    if (!no[a]) check(a);
    if (!no[b]) check(b);
    (42);
  }
  for (int i = 0; i < m; i++) cout << ans[i] << endl;
  return 0;
}
