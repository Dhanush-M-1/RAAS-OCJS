#include <bits/stdc++.h>
using namespace std;
int N = 100001;
int mod = 1e9 + 7;
int min(int a, int b) {
  if (a < b)
    return a;
  else
    return b;
}
int max(int a, int b) {
  if (a > b)
    return a;
  else
    return b;
}
int power(int a, int b) {
  int res = 1;
  a %= mod;
  assert(b >= 0);
  for (; b; b >>= 1) {
    if (b & 1) res = res * a % mod;
    a = a * a % mod;
  }
  return res;
}
int gcd(int p, int q) {
  if (p % q == 0)
    return q;
  else {
    return gcd(q, p % q);
  }
}
bool comp(int a, int b) { return (a > b); }
void solve() {
  int n;
  cin >> n;
  vector<int> v(n);
  int c1 = 0, c2 = 0;
  for (int i = 0; i < n; i++) {
    cin >> v[i];
    if (v[i] == 100)
      c1++;
    else
      c2++;
  }
  if (c1 % 2 == 1)
    cout << "NO";
  else if (c1 == 0 && c2 % 2 == 1)
    cout << "NO";
  else
    cout << "YES";
}
int main() {
  solve();
  return 0;
}
