#include <bits/stdc++.h>
using namespace std;
int N, K;
int x;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> N >> K;
  int ans = (int)1e9;
  for (int i = 0; i < N; i++) {
    cin >> x;
    if (K % x == 0) {
      ans = min(ans, K / x);
    }
  }
  cout << ans << '\n';
  return 0;
}
