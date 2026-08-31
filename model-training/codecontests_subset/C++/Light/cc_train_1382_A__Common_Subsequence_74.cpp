#include <bits/stdc++.h>
using namespace std;
int main() {
  long long t;
  cin >> t;
  while (t > 0) {
    long long n, m;
    cin >> n >> m;
    unordered_set<long long> s;
    for (long long i = 0; i < n; i++) {
      long long a;
      cin >> a;
      s.insert(a);
    }
    long long b;
    long long k;
    bool found = false;
    for (long long i = 0; i < m; i++) {
      cin >> b;
      if (s.find(b) != s.end()) {
        k = b;
        found = true;
      }
    }
    if (found) {
      cout << "YES" << endl;
      cout << 1 << " " << k << endl;
    } else {
      cout << "NO" << endl;
    }
    t--;
  }
}
