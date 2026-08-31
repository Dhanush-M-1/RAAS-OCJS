#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);
  long long t;
  cin >> t;
  while (t--) {
    long long n, m, a;
    cin >> n >> m;
    set<long long> s;
    for (long long i = 0; i < n; i++) {
      cin >> a;
      s.insert(a);
    }
    long long f = -1;
    for (long long i = 0; i < m; i++) {
      cin >> a;
      if (s.find(a) != s.end()) {
        f = a;
      }
    }
    if (f == -1)
      cout << "NO"
           << "\n";
    else {
      cout << "YES"
           << "\n"
           << 1 << " " << f << "\n";
    }
  }
  return 0;
}
