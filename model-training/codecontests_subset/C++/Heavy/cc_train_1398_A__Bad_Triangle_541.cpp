#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2,fma")
using namespace std;
int arrg[1000000];
int nxt() {
  int x;
  cin >> x;
  return x;
}
int lxt() {
  long long x;
  cin >> x;
  return x;
}
int dxt() {
  double x;
  cin >> x;
  return x;
}
int ldxt() {
  long double x;
  cin >> x;
  return x;
}
bool cmp(const pair<int, int> &p, const pair<int, int> &q) {
  if (p.first < q.first)
    return 1;
  else if (p.first == q.first)
    return (p.second < q.second);
  else
    return 0;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int tc;
  cin >> tc;
  for (int z = 1; z <= tc; z++) {
    long long n = nxt(), p = 1;
    vector<long long> v(n);
    for (int i = 0; i < n; i++) cin >> v[i];
    sort((v).begin(), (v).end());
    long long x = *max_element((v).begin(), (v).end());
    for (long long j = 1; j <= n - 2 && p == 1; j++) {
      if ((v[0] + v[j]) <= x) {
        cout << 1 << " " << j + 1 << " " << n << "\n";
        p = 0;
      }
    }
    if (p) cout << (-1) << "\n";
  }
  return 0;
}
