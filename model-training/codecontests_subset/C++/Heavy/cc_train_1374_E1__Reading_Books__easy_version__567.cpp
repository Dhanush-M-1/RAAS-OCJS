#include <bits/stdc++.h>
using namespace std;
const long long mod = 1e9 + 7;
const int inf = 1e9 + 7;
const double eps = 1e-6;
long long qpow(long long a, long long b, long long m) {
  long long r = 1;
  a %= m;
  for (; b; b >>= 1) {
    if (b & 1) r = r * a % m;
    a = a * a % m;
  }
  return (r + m) % m;
}
const double pi = acos(-1);
long long ar[202030], res = 0, p[4] = {0};
bool cmp(long long a, long long b) { return ar[a] < ar[b]; }
int main() {
  ios::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  long long n, m, k, tot = 0;
  cin >> n >> m >> k;
  vector<long long> v[4];
  set<long long> ans;
  for (long long i = 0; i < n; i++) {
    long long p, q;
    cin >> ar[i] >> p >> q;
    v[2 * p + q].push_back(i);
  }
  for (int i = 0; i < 4; i++) {
    sort(v[i].begin(), v[i].end(), cmp);
  }
  for (int i = 0; i < min((long long)v[3].size(), k); i++)
    ans.insert(v[3][i]), p[3]++;
  long long sz = min(v[1].size(), v[2].size());
  if ((long long)v[3].size() + sz < k) {
    cout << -1;
    return 0;
  }
  for (int i = 0; i < k - (long long)v[3].size(); i++) {
    ans.insert(v[1][p[1]]), p[1]++;
    ans.insert(v[2][p[2]]), p[2]++;
  }
  long long cnt = 10;
  while ((long long)ans.size() < m) {
    long long mn = 1e7, id = -1;
    for (long long i = 0; i < 4; i++) {
      if (p[i] == (long long)v[i].size()) continue;
      if (mn > ar[v[i][p[i]]]) mn = ar[v[i][p[i]]], id = i;
    }
    if (p[3] > 0 && p[1] < v[1].size() && p[2] < v[2].size() &&
        ar[v[1][p[1]]] + ar[v[2][p[2]]] < mn + ar[v[3][p[3] - 1]]) {
      ans.erase(v[3][--p[3]]);
      ans.insert(v[1][p[1]++]);
      ans.insert(v[2][p[2]++]);
    } else
      ans.insert(v[id][p[id]++]);
  }
  if ((long long)ans.size() != m) {
    cout << -1;
    return 0;
  }
  long long sum = 0;
  for (auto i : ans) sum += ar[i];
  cout << sum << '\n';
  for (auto i : ans) cout << i + 1 << ' ';
  return 0;
}
