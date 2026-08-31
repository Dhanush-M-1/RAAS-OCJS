#include <bits/stdc++.h>
using namespace std;
template <class T>
inline void sarray(T *st, T *nd) {
  while (st < nd) cin >> *st++;
}
template <class T>
inline void parray(T *st, T *nd) {
  while (st < nd) cout << *st++ << endl;
}
long long int tmp, ans;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  int n;
  cin >> n;
  vector<pair<int, int>> v;
  int a, b;
  for (int i = 0; i < n; i++) {
    cin >> a >> b;
    v.emplace_back(make_pair(a, b));
  }
  if (n == 1)
    cout << 1 << endl;
  else if (n == 2)
    cout << 2 << endl;
  else {
    ans = 2;
    for (int i = 1; i < n - 1; i++) {
      if (v[i].first - v[i - 1].first > v[i].second)
        ans++;
      else if (v[i + 1].first - v[i].first > v[i].second) {
        ans++;
        v[i].first += v[i].second;
      }
    }
    cout << ans << endl;
  }
  return 0;
}
