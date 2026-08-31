#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long t;
  cin >> t;
  while (t--) {
    long long n, m;
    cin >> n >> m;
    long long a[n];
    long long b[m];
    map<long long, long long> mp;
    for (long long i = 0; i < n; i++) {
      cin >> a[i];
      if (mp[a[i]] == 0) {
        mp[a[i]]++;
      }
    }
    long long ans = -1;
    long long k = 0;
    long long sum = 0;
    for (long long i = 0; i < m; i++) {
      cin >> b[i];
      if (mp[b[i]] == 1) {
        if (k == 0) {
          ans = 0;
          sum = b[i];
        }
        k++;
      }
    }
    if (ans == 0) {
      cout << "YES" << endl;
      cout << 1 << " " << sum << endl;
    } else {
      cout << "NO" << endl;
    }
  }
  return 0;
}
