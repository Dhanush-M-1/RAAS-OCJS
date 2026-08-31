#include <bits/stdc++.h>
using namespace std;
const long double EPS = 1e-6;
const long double pi = acos(-1);
int main() {
  ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  long long t;
  cin >> t;
  while (t--) {
    long long n, m;
    cin >> n >> m;
    vector<long long> a(n), b(m);
    set<long long> s;
    for (long long i = 0; i < n; i++) {
      cin >> a[i];
      s.insert(a[i]);
    }
    long long r;
    bool y = false;
    for (long long i = 0; i < m; i++) {
      cin >> b[i];
      if (s.find(b[i]) != s.end()) {
        r = b[i];
        y = true;
      }
    }
    if (y) {
      cout << "YES" << endl;
      cout << "1 " << r << endl;
    } else {
      cout << "NO" << endl;
    }
  }
  return 0;
}
