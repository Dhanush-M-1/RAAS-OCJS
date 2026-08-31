#include <bits/stdc++.h>
using namespace std;
long long power(long long base, long long exp) {
  long long res = 1;
  while (exp > 0) {
    if (exp % 2 == 1) res = (res * base);
    base = (base * base);
    exp /= 2;
  }
  return res;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    long long n, m;
    cin >> n >> m;
    long long *a = new long long[n];
    long long *b = new long long[m];
    set<long long> s;
    for (long long i = 0; i < n; i++) {
      cin >> a[i];
      if (s.find(a[i]) == s.end()) {
        s.insert(a[i]);
      }
    }
    long long ans = -1;
    for (long long i = 0; i < m; i++) {
      cin >> b[i];
      if (s.find(b[i]) != s.end()) {
        ans = b[i];
      }
    }
    if (ans == -1) {
      cout << "NO"
           << "\n";
    } else {
      cout << "YES"
           << "\n";
      cout << 1 << " " << ans << "\n";
    }
    delete[] a;
    delete[] b;
  }
  return 0;
}
