#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC optimize("unroll-loops")
#pragma GCC optimize("-ffloat-store")
#pragma GCC optimize("-fno-defer-pop")
long long int power(long long int a, long long int b, long long int m) {
  if (b == 0) return 1;
  if (b == 1) return a % m;
  long long int t = power(a, b / 2, m) % m;
  t = (t * t) % m;
  if (b & 1) t = ((t % m) * (a % m)) % m;
  return t;
}
long long int modInverse(long long int a, long long int m) {
  return power(a, m - 2, m);
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  char a, b;
  cin >> a >> b;
  long long int i, j = 0, k = 0, l = 0, n;
  cin >> n;
  char ar[n][3];
  for (i = 0; i < n; i++) {
    cin >> ar[i];
    if (ar[i][0] == a && ar[i][1] == b) {
      l = 1;
    }
    if (ar[i][0] == b) k = 1;
    if (ar[i][1] == a) j = 1;
  }
  if (l == 1 || (k == 1 && j == 1)) {
    cout << "YES\n";
  } else {
    cout << "NO\n";
  }
  return 0;
}
