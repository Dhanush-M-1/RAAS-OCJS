#include <bits/stdc++.h>
using namespace std;
long long int powMod(long long int x, long long int y) {
  long long int p = 1;
  while (y) {
    if (y % 2) {
      p = (p * x) % 1000000007;
    }
    y /= 2;
    x = (x * x) % 1000000007;
  }
  return p;
}
long long int invMod(long long int x) { return powMod(x, 1000000007 - 2); }
long long int gcd(long long int a, long long int b) {
  return b == 0 ? a : gcd(b, a % b);
}
bool sortbysec(const pair<long long int, long long int> &a,
               const pair<long long int, long long int> &b) {
  if (a.first == b.first) {
    return (a.second < b.second);
  }
  return (a.first > b.first);
}
void solve() {
  long long int n;
  cin >> n;
  vector<pair<long long int, long long int> > v;
  long long int k[n];
  for (long long int i = 0; i < n; i++) {
    cin >> k[i];
    v.push_back(make_pair(k[i], i));
  }
  sort(v.begin(), v.end(), sortbysec);
  long long int m;
  cin >> m;
  for (long long int i = 0; i < m; i++) {
    long long int a, b;
    cin >> a >> b;
    long long int ans[a];
    for (long long int j = 0; j < a; j++) {
      ans[j] = v[j].second;
    }
    sort(ans, ans + a);
    cout << k[ans[b - 1]] << '\n';
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  solve();
  return 0;
}
