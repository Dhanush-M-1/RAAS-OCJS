#include <bits/stdc++.h>
using namespace std;
const long long INF = 1e9 + 123, MAXN = 2e5 + 47;
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
template <class T, class D>
istream& operator>>(istream& in, vector<pair<T, D>>& a) {
  for (auto& i : a) in >> i.first >> i.second;
  return in;
}
template <class T, class D>
ostream& operator<<(ostream& out, vector<pair<T, D>>& a) {
  for (auto& i : a) out << i.first << " " << i.second << endl;
  return out;
}
signed main() {
  setlocale(LC_ALL, "rus");
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long n, d;
  cin >> n >> d;
  vector<long long> a(n);
  cin >> a;
  vector<long long> pref(n);
  pref[0] = a[0];
  long long ans = 0;
  vector<long long> suff(n);
  suff.back() = a.back();
  for (long long i = n - 2; i >= 0; --i)
    suff[i] = max({suff[i + 1] + a[i], suff[i], 0ll, a[i]});
  if (pref[0] > d) return cout << -1, 0;
  for (long long i = 1; i < n; ++i) {
    pref[i] = pref[i - 1] + a[i];
    if (a[i] == 0) {
      if (pref[i] < 0) {
        ++ans;
        pref[i] = d - suff[i];
        if (pref[i] < 0) return cout << -1, 0;
      }
    }
    if (pref[i] > d) return cout << -1, 0;
  }
  cout << ans;
}
