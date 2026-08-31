#include <bits/stdc++.h>
using namespace std;
const long long N = 1e5 + 5;
long long n, m, i, j, k;
set<long long> a, b;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  if (0)
    ;
  long long t;
  cin >> t;
  while (t--) {
    a.clear();
    b.clear();
    cin >> n >> m;
    for (i = 0; i < n; i++) {
      cin >> k;
      a.insert(k);
    }
    for (i = 0; i < m; i++) {
      cin >> k;
      b.insert(k);
    }
    for (i = 1; i <= 1000; i++) {
      if (a.count(i) > 0 && b.count(i) > 0) {
        cout << "YES" << endl << 1 << " " << i << endl;
        break;
      }
    }
    if (i == 1001) cout << "NO" << endl;
  }
}
