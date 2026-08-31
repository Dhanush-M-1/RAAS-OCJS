#include <bits/stdc++.h>
using namespace std;
const int MAX = 100005, MOD = 1000000007;
const long long inf = 1e9;
int arr[MAX];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  ;
  int t;
  cin >> t;
  while (t--) {
    int ans = 0, ch = 0;
    int a, b, c;
    cin >> a >> b >> c;
    int p, q, r;
    p = a, q = b, r = c;
    int f = min(q / 2, p);
    ch = 3 * f;
    p -= f;
    q -= (2 * f);
    f = min(r / 2, q);
    ch += (3 * f);
    ans = max(ans, ch);
    p = a, q = b, r = c;
    f = min(r / 2, q);
    ch = 3 * f;
    q -= f;
    r -= (2 * f);
    f = min(q / 2, p);
    ch += (3 * f);
    ans = max(ans, ch);
    cout << ans << "\n";
  }
}
