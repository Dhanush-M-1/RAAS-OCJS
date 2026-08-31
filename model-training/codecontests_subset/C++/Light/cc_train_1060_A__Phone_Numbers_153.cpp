#include <bits/stdc++.h>
using namespace std;
const int inf = (int)1e9;
const int mod = inf + 7;
const double eps = 1e-9;
const double pi = acos(-1.0);
int n;
string second;
int cnt[1111];
int main() {
  ios_base::sync_with_stdio(0), cin.tie(0);
  cin >> n >> second;
  for (int i = 0; i < n; ++i) {
    cnt[second[i] - '0']++;
  }
  int x = cnt[8];
  int sum = 0;
  for (int i = 0; i <= 9; ++i) {
    sum += cnt[i];
  }
  int ans = 0;
  for (int i = 1; i <= x; ++i) {
    if ((sum - i) >= 10 * i) ans = i;
  }
  cout << ans << endl;
}
