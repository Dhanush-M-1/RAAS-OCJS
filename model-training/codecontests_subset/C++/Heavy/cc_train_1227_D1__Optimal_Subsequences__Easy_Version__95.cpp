#include <bits/stdc++.h>
using namespace std;
const long long INF = 1e9 + 123, MAXN = 5e5 + 47, MEGAINF = 1e18 + 228;
template <class T>
inline istream& operator>>(istream& in, vector<T>& a) {
  for (auto& i : a) in >> i;
  return in;
}
template <class T>
inline ostream& operator<<(ostream& out, vector<T>& a) {
  for (auto i : a) out << i << " ";
  return out;
}
template <class T, class U>
inline istream& operator>>(istream& in, vector<pair<T, U>>& a) {
  for (auto& i : a) in >> i.first >> i.second;
  return in;
}
template <class T, class U>
inline ostream& operator<<(ostream& out, vector<pair<T, U>>& a) {
  for (auto& i : a) out << i.first << " " << i.second << "\n";
  return out;
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
  vector<pair<long long, long long>> p;
  for (long long i = 0; i < n; ++i) p.push_back({a[i], i});
  sort(p.begin(), p.end(),
       [&](pair<long long, long long> one, pair<long long, long long> two) {
         if (one.first == two.first) return one.second < two.second;
         return one.first > two.first;
       });
  long long m;
  cin >> m;
  while (m--) {
    long long k, pos;
    cin >> k >> pos;
    --pos;
    vector<long long> have;
    for (long long i = 0; i < k; ++i) have.push_back(p[i].second);
    sort(have.begin(), have.end());
    long long ind = have[pos];
    cout << a[ind] << "\n";
  }
}
