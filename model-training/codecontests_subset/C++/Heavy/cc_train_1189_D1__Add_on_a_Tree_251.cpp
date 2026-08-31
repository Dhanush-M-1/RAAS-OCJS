#include <bits/stdc++.h>
using namespace std;
void err(istream_iterator<string> it) {}
template <typename S37, typename... Args>
void err(istream_iterator<string> it, S37 a, Args... args) {
  cerr << *it << " = " << a << endl;
  err(++it, args...);
}
const long long N = 200010, mod = 1e9 + 7, mod2 = 1e9 + 9, mod3 = 998244353,
                sq = 450, base = 37, lg = 25, inf = 1e18 + 10, del = 67733;
long long n, m, x, y, w, z, X, Y, Z, t, k, ans, a[N];
vector<long long> v[N];
int main() {
  ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  cin >> n;
  for (int i = 0; i < n - 1; i++) {
    cin >> x >> y;
    v[x].push_back(y);
    a[x]++;
    a[y]++;
    v[y].push_back(x);
  }
  for (int i = 1; i <= n; i++) {
    if (a[i] == 2) return cout << "NO", 0;
  }
  cout << "YES";
  return 0;
}
