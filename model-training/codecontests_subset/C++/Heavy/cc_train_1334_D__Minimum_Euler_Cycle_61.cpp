#include <bits/stdc++.h>
using namespace std;
const long long N = 200001;
const long long MOD = 1000000007;
const long long INF = LLONG_MAX;
vector<long long> v;
void pre() {
  v.push_back(1LL);
  for (long long i = 1; i <= 1e5; i++) v.push_back(i * 2);
  for (long long i = 1; i < v.size(); i++) v[i] += v[i - 1];
}
long long Getfirst(long long n, long long x) {
  long long id = upper_bound(v.begin(), v.end(), x) - v.begin();
  return (n - id);
}
long long Getlast(long long n, long long x) {
  long long id = upper_bound(v.begin(), v.end(), x) - v.begin() - 1;
  long long dif = x - v[id] + 1;
  return (n - dif / 2);
}
int main() {
  ios::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  pre();
  int tc = 1, cs = 0;
  cin >> tc;
  while (tc--) {
    long long n, l, r, i, limit;
    cin >> n >> l >> r;
    limit = n * (n - 1) + 1;
    vector<long long> ans;
    for (i = l; i <= r; i++) {
      if (i == limit) {
        ans.push_back(1);
        break;
      }
      if (i & 1)
        ans.push_back(Getfirst(n, limit - i));
      else
        ans.push_back(Getlast(n, limit - i));
    }
    for (auto it : ans) cout << it << ' ';
    cout << '\n';
    ;
  }
}
