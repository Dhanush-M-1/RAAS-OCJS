#include <bits/stdc++.h>
using namespace std;
void serotonin() {}
int32_t main() {
  serotonin();
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long t = 1;
  while (t--) {
    long long a;
    cin >> a;
    long long tree[a];
    long long height[a];
    for (long long i = 0; i < a; i++) cin >> tree[i] >> height[i];
    long long ans = 2;
    for (long long i = 1; i < a - 1; i++) {
      if (tree[i] - tree[i - 1] > height[i])
        ans++;
      else if (tree[i + 1] - tree[i] > height[i]) {
        tree[i] += height[i];
        ans++;
      }
    }
    if (a == 1) ans = 1;
    cout << ans << "\n";
  }
  return 0;
}
