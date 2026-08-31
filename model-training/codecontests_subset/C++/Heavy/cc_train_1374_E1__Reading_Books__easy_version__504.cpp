#include <bits/stdc++.h>
using namespace std;
long long gcd(long long a, long long b) { return b ? gcd(b, a % b) : a; }
long long powM(long long x, long long y, long long m) {
  if (y == 0) return 1;
  long long p = powM(x, y / 2, m) % m;
  p = (p * p) % m;
  return (y % 2 == 0) ? p : (x * p) % m;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n, k;
  cin >> n >> k;
  vector<int> vt, va, vb;
  for (long long i = 1; i <= n; i++) {
    int t, a, b;
    cin >> t >> a >> b;
    if (a == 1 && b == 1) vt.push_back(t);
    if (a == 1 && b == 0) va.push_back(t);
    if (a == 0 && b == 1) vb.push_back(t);
  }
  sort(va.begin(), va.end());
  sort(vb.begin(), vb.end());
  for (long long i = 0; i <= min((int)va.size() - 1, (int)vb.size() - 1); i++)
    vt.push_back(va[i] + vb[i]);
  sort(vt.begin(), vt.end());
  if ((int)vt.size() < k) {
    cout << -1 << '\n';
    return 0;
  }
  int sum = 0;
  for (long long i = 0; i <= k - 1; i++) sum += vt[i];
  cout << sum << '\n';
  return 0;
}
