#include <bits/stdc++.h>
using namespace std;
long long bigmod(long long b, long long p, long long md) {
  if (p == 0) return 1;
  if (p % 2 == 1) {
    return ((b % md) * bigmod(b, p - 1, md)) % md;
  } else {
    long long y = bigmod(b, p / 2, md);
    return (y * y) % md;
  }
}
int deg[100005];
int main() {
  int n;
  cin >> n;
  for (int i = 1; i < n; i++) {
    int a, b;
    cin >> a >> b;
    deg[a]++;
    deg[b]++;
  }
  for (int i = 1; i <= n; i++) {
    if (deg[i] == 2) {
      cout << "NO" << endl;
      return 0;
    }
  }
  cout << "YES" << endl;
  return 0;
}
