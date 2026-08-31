#include <bits/stdc++.h>
using namespace std;
long long gcd(long long a, long long b) {
  if (a > b) {
    long long tmp = a;
    a = b;
    b = tmp;
  }
  while (a) {
    long long tmp = b % a;
    b = a;
    a = tmp;
  }
  return b;
}
int main() {
  ios::sync_with_stdio(0);
  int t;
  cin >> t;
  while (t--) {
    long long n, m, i, j, k;
    cin >> n >> m;
    vector<long long> a(n), b(m), h1(1001, 0), h2(1001, 0);
    long long flag = 0;
    for (i = 0; i < n; i++) {
      cin >> a[i];
      h1[a[i]]++;
    }
    for (i = 0; i < m; i++) {
      cin >> b[i];
      h2[b[i]]++;
    }
    long long val = -1;
    for (i = 1; i <= 1000; i++) {
      if (h1[i] && h2[i]) {
        flag = 1;
        val = i;
        break;
      }
    }
    if (flag) {
      cout << "YES" << endl;
      cout << 1 << " " << val << endl;
    } else
      cout << "NO" << endl;
  }
}
