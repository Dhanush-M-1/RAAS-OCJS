#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1000 * 1000 + 10;
int a[MAXN];
long long int mod = 1000 * 1000 * 1000 + 7;
int main() {
  ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  int q;
  cin >> q;
  for (int i = 0; i < q; i++) {
    int a, b, c;
    cin >> a >> b >> c;
    int ans = min(c / 2, b);
    b -= ans;
    ans += min(b / 2, a);
    cout << ans * 3 << endl;
  }
  return 0;
}
