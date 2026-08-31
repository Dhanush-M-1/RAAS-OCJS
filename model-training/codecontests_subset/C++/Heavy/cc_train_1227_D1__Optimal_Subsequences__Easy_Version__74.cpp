#include <bits/stdc++.h>
using namespace std;
const long long INF = 1e9 + 123, MAXN = 2e5 + 47;
long long p = 41;
template <class T>
istream& operator>>(istream& in, vector<T>& a) {
  for (auto& i : a) in >> i;
  return in;
}
template <class T>
ostream& operator<<(ostream& out, vector<T>& a) {
  for (auto& i : a) out << i << " ";
  return out;
}
template <class T, class U>
istream& operator>>(istream& in, vector<pair<T, U>>& a) {
  for (auto& i : a) in >> i.first >> i.second;
  return in;
}
template <class T, class U>
ostream& operator<<(ostream& out, vector<pair<T, U>>& a) {
  for (auto& i : a) out << i.first << " " << i.second << endl;
  return out;
}
bool cmp(pair<long long, long long>& a, pair<long long, long long>& b) {
  if (a.first > b.first) return 1;
  if (a.first < b.first) return 0;
  if (a.first == b.first) {
    if (a.second < b.second)
      return 1;
    else
      return 0;
  }
}
signed main() {
  setlocale(LC_ALL, "rus");
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long n;
  cin >> n;
  vector<long long> a(n);
  cin >> a;
  vector<pair<long long, long long>> p(n);
  for (long long i = 0; i < n; ++i) p[i] = make_pair(a[i], i);
  sort(p.begin(), p.end(), cmp);
  long long m;
  cin >> m;
  while (m--) {
    long long k, pos;
    cin >> k >> pos;
    vector<long long> b(n, 0);
    for (long long i = 0; i < k; ++i) b[p[i].second] = p[i].first;
    vector<long long> ans;
    for (long long i = 0; i < n; ++i)
      if (b[i]) ans.push_back(b[i]);
    cout << ans[pos - 1] << endl;
  }
}
