#include <bits/stdc++.h>
using namespace std;
mt19937_64 rng(chrono::steady_clock::now().time_since_epoch().count());
const int inf = 1e9;
const long long INF = 1e18;
const long long mod = 1e9 + 7;
clock_t time_p = clock();
void ktj() {
  time_p = clock() - time_p;
  cerr << "Time elapsed : " << (float)(time_p) / CLOCKS_PER_SEC << "\n";
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int a, b, c;
    cin >> a >> b >> c;
    int ans = 0;
    for (int i = 0; i <= b; i++) {
      int now = 0;
      int left;
      if (2 * a <= i) {
        now += 3 * a;
        left = b - 2 * a;
      } else {
        now += 3 * (i / 2);
        left = b - i;
      }
      if (2 * left <= c) {
        now += 3 * left;
      } else {
        now += 3 * (c / 2);
      }
      ans = max(ans, now);
    }
    cout << ans << '\n';
  }
  ktj();
}
