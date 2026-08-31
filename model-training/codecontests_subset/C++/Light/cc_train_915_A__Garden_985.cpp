#include <bits/stdc++.h>
using namespace std;
const int dx[4] = {0, 1, 0, -1};
const int dy[4] = {1, 0, -1, 0};
const long long int linf = 99999999999999999ll;
const int maxn = 1e5 + 10;
long long int gcd(long long int a, long long int b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
long long int lcm(long long int a, long long int b) {
  return (a * b) / gcd(a, b);
}
int a[maxn];
int main() {
  ios_base::sync_with_stdio(false);
  int n, k, mx = 0;
  cin >> n >> k;
  for (int i = 0; i < n; i++) cin >> a[i];
  for (int i = 0; i < n; i++) {
    if (k % a[i] == 0) {
      mx = max(mx, a[i]);
    }
  }
  cout << k / mx << endl;
  return 0;
}
