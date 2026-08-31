#include <bits/stdc++.h>
using namespace std;
long long int mod1 = 1000000007;
long long int mod2 = 67280421310721;
long long int mod3 = 998244353;
long long int INF = 1e18;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int t;
  cin >> t;
  while (t--) {
    int n, l;
    cin >> n >> l;
    map<int, int> m;
    for (int i = 0; i < n; i++) {
      int x;
      cin >> x;
      m[x]++;
    }
    bool f = 0;
    int ans = 0;
    for (int i = 0; i < l; i++) {
      int x;
      cin >> x;
      if (m[x] > 0) {
        f = 1;
        ans = x;
      }
    }
    if (f)
      cout << "YES\n"
           << "1 " << ans << "\n";
    else
      cout << "NO\n";
  }
  return 0;
}
