#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long t;
  cin >> t;
  while (t--) {
    long long n, m;
    cin >> n >> m;
    set<long long> s;
    long long temp;
    long long ans = -1;
    for (int i = 0; i < n; i++) {
      cin >> temp;
      s.insert(temp);
    }
    for (int i = 0; i < m; i++) {
      cin >> temp;
      if (s.count(temp) && ans == -1) {
        ans = temp;
      }
    }
    if (ans != -1) {
      cout << "YES" << endl << 1 << " " << ans << endl;
    } else {
      cout << "NO" << endl;
    }
  }
  return 0;
}
