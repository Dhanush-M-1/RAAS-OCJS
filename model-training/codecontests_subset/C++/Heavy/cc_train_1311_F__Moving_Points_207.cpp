#include <bits/stdc++.h>
using namespace std;
const int MAX_N = 100011;
const long long INF = (1 << 29) + 123;
const long long MOD = 1000000007;
const long double PI = 4 * atan((long double)1);
int fenw[2 * MAX_N];
int n;
void mod(int i, int v) {
  while (i <= n) {
    fenw[i] += v;
    i += i & -i;
  }
}
int query(int i) {
  int sum = 0;
  while (i > 0) {
    sum += fenw[i];
    i -= i & -i;
  }
  return sum;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  vector<pair<int, int> > p;
  int x[n], v[n];
  for (int i = 0; i < n; i++) cin >> x[i];
  for (int i = 0; i < n; i++) {
    cin >> v[i];
    p.push_back(make_pair(v[i], x[i]));
  }
  unordered_map<int, int> m;
  int rev_map[n];
  sort(x, x + n);
  for (int i = 0; i < n; i++) {
    m[x[i]] = i + 1;
    rev_map[i] = x[i];
  }
  for (int i = 0; i < n; i++) {
    p[i].second = m[p[i].second];
  }
  sort(p.begin(), p.end());
  long long ans = 0;
  for (int i = 0; i < n; i++) {
    int q = query(p[i].second);
    ans += 1LL * q * rev_map[p[i].second - 1];
    ans -=
        1LL * ((n - i - 1) - (p[i].second - 1 - q)) * rev_map[p[i].second - 1];
    mod(p[i].second, 1);
  }
  cout << ans << endl;
  return 0;
}
