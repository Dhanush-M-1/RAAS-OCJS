#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 3;
const int maxm = 1e6 + 3;
const int mod = 1e9 + 7;
const int oo = 1e9 + 5;
const long double pi = 3.141592653589793238462643383279502884;
void input() {
  if (fopen("abc"
            ".inp",
            "r")) {
    freopen(
        "abc"
        ".inp",
        "r", stdin);
    freopen(
        "abc"
        ".out",
        "w", stdout);
  }
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
}
int n;
pair<long long, long long> a[maxn], f[maxn];
vector<long long> v;
pair<long long, long long> operator+(const pair<long long, long long>& a,
                                     const pair<long long, long long>& b) {
  return {a.first + b.first, a.second + b.second};
}
void update(int p, int v) {
  for (int i = p; i <= n; i += i & -i)
    f[i] = f[i] + pair<long long, long long>(v, 1);
}
pair<long long, long long> get(int p) {
  pair<long long, long long> ans = {0, 0};
  for (int i = p; i > 0; i -= i & -i) ans = ans + f[i];
  return ans;
}
int main() {
  input();
  cin >> n;
  for (int i = 1; i <= n; ++i) cin >> a[i].first;
  for (int i = 1; i <= n; ++i) {
    cin >> a[i].second;
    v.push_back(a[i].second);
  }
  sort(a + 1, a + 1 + n);
  sort(v.begin(), v.end());
  v.resize(unique(v.begin(), v.end()) - v.begin());
  long long ans = 0;
  for (int i = 1; i <= n; ++i) {
    auto it = lower_bound(v.begin(), v.end(), a[i].second) - v.begin() + 1;
    pair<long long, long long> cur = get(it);
    ans += a[i].first * cur.second - cur.first;
    update(it, a[i].first);
  }
  cout << ans;
  return 0;
}
