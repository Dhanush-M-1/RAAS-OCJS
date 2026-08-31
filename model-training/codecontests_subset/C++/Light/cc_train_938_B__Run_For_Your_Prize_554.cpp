#include <bits/stdc++.h>
using namespace std;
const int N = 1000000;
int long long n, l, r, ll, rr, i, ans = 1e9, a[100005];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> n;
  r = 1e6;
  a[0] = 1;
  a[n + 1] = r;
  for (i = 1; i <= n; i++) {
    cin >> a[i];
    ans =
        min(ans, min(max(a[i] - 1, r - a[i + 1]), max(a[i - 1] - 1, r - a[i])));
  }
  cout << ans << endl;
}
