#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
const long long LINF = 0x3f3f3f3f3f3f3f3fll;
const int MAX = 2e5 + 10;
vector<pair<int, int>> v(MAX);
vector<int> spdv(MAX), compress(MAX);
long long n, bit[2][MAX];
void poe(int a, long long x, long long p) {
  for (; p <= n; p += p & -p) bit[a][p] += x;
}
long long pref(int a, long long p) {
  long long ret = 0;
  for (; p; p -= p & -p) ret += bit[a][p];
  return ret;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> v[i].first;
    v[i].second = i;
  }
  for (int i = 0; i < n; i++) {
    cin >> spdv[i];
    compress[i] = spdv[i];
  }
  sort(v.begin(), v.begin() + n);
  sort(compress.begin(), compress.begin() + n);
  map<int, int> newidx;
  for (int i = 0; i < n; i++) newidx[compress[i]] = i;
  long long ans = 0;
  for (int i = 0; i < n; i++) {
    int pos = newidx[spdv[v[i].second]] + 1;
    ans += v[i].first * pref(0, pos) - pref(1, pos);
    poe(0, 1, pos);
    poe(1, v[i].first, pos);
  }
  cout << ans << '\n';
  return 0;
}
