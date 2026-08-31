#include <bits/stdc++.h>
using namespace std;
int mx = (int)1e6 * -1;
int mn = (int)1e9;
void go_fast() {
  ios_base ::sync_with_stdio(0);
  cin.tie(0), cout.tie(0);
}
bool ok;
int a[280000], p[111111], b[111111];
string s;
long long cnt, ans, res, sum;
int main() {
  go_fast();
  int n;
  cin >> n;
  for (int i = 1; i <= n; ++i) {
    cin >> a[i];
    sum += a[i];
  }
  for (int i = 1; i <= n - 1; ++i) {
    cin >> p[i];
    cnt += p[i];
  }
  for (int i = 1; i <= n - 2; ++i) {
    cin >> b[i];
    ans += b[i];
  }
  cout << sum - cnt << "\n" << cnt - ans;
  return 0;
}
