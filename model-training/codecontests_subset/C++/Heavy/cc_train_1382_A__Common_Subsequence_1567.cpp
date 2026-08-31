#include <bits/stdc++.h>
using namespace std;
const long long mod = 1e9 + 7;
const long long N = 2e5 + 5;
long long n, m, x, y, p, q, k, a, b, c, ans, res;
int main() {
  long long t;
  cin >> t;
  while (t--) {
    long long n, m;
    cin >> n >> m;
    map<long long, long long> ress;
    long long a[n], b[m];
    long long flag = 0;
    for (long long i = 0; i < n; i++) {
      cin >> a[i];
      ress[a[i]] = 1;
    }
    for (long long i = 0; i < m; i++) {
      cin >> b[i];
      if (ress[b[i]] == 1) flag = b[i];
    }
    if (flag == 0)
      cout << "NO" << endl;
    else {
      cout << "YES" << endl;
      cout << 1 << " " << flag << endl;
    }
  }
}
