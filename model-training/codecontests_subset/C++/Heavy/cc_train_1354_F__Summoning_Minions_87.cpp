#include <bits/stdc++.h>
using namespace std;
template <class T>
ostream &operator<<(ostream &os, vector<T> V) {
  os << "[ ";
  for (auto v : V) os << v << " ";
  os << "]";
  return os;
}
template <class T>
ostream &operator<<(ostream &os, set<T> S) {
  os << "{ ";
  for (auto s : S) os << s << " ";
  return os << "}";
}
template <class L, class R>
ostream &operator<<(ostream &os, map<L, R> M) {
  os << "{ ";
  for (auto m : M) os << "(" << m.first << ":" << m.second << ") ";
  return os << "}";
}
template <class L, class R>
ostream &operator<<(ostream &os, pair<L, R> P) {
  return os << "(" << P.first << "," << P.second << ")";
}
const long long N = 75;
long long n, k, dp[N][N], taken[N][N];
vector<pair<pair<long long, long long>, long long>> p;
vector<long long> v1, v2;
bool compare(pair<pair<long long, long long>, long long> &a,
             pair<pair<long long, long long>, long long> &b) {
  if (a.first.second != b.first.second) return a.first.second < b.first.second;
  return a.first.first < b.first.first;
}
bool compare1(long long a, long long b) {
  return p[a].first.first < p[b].first.first;
}
long long rec(long long in, long long done) {
  if (in == n) {
    if (done == k) return 0;
    return -1e18;
  }
  if (dp[in][done] != -1) return dp[in][done];
  long long x = (k - 1) * p[in].first.second + rec(in + 1, done);
  taken[in][done] = 0;
  if (done < k) {
    if (done * p[in].first.second + p[in].first.first + rec(in + 1, done + 1) >
        x)
      taken[in][done] = 1,
      x = done * p[in].first.second + p[in].first.first + rec(in + 1, done + 1);
  }
  return dp[in][done] = x;
}
void restore(long long in, long long done) {
  if (in == n) return;
  if (taken[in][done] == 1)
    v1.push_back(in), restore(in + 1, done + 1);
  else
    v2.push_back(in), restore(in + 1, done);
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long t;
  cin >> t;
  while (t--) {
    cin >> n >> k;
    p.clear();
    p.resize(n);
    for (long long i = 0; i < n; i++)
      cin >> p[i].first.first >> p[i].first.second, p[i].second = i + 1;
    sort(p.begin(), p.end(), compare);
    memset(dp, -1, sizeof(dp));
    v1.clear(), v2.clear();
    rec(0, 0);
    restore(0, 0);
    vector<long long> ans;
    sort(v2.begin(), v2.end(), compare1);
    for (long long i = 0; i < v1.size() - 1; i++)
      ans.push_back(p[v1[i]].second);
    if (v1.size() == 1) ans.push_back(p[v1[0]].second);
    if (v1.size() > 1 || (v1.size() == 1 && k > 1))
      for (long long i = 0; i < v2.size(); i++)
        ans.push_back(p[v2[i]].second), ans.push_back(-p[v2[i]].second);
    if (v1.size() > 1) ans.push_back(p[v1.back()].second);
    cout << ans.size() << '\n';
    for (auto it : ans) cout << it << ' ';
    cout << '\n';
  }
  return 0;
}
