#include <bits/stdc++.h>
using namespace std;
const long long INF = 2e9 + 13;
const long long MOD = 1e9 + 7;
int N, D;
int V[300005];
int suf[300005];
int main(void) {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cin >> N >> D;
  for (int i = 1; i <= N; i++) {
    cin >> V[i];
  }
  for (int i = N; i >= 1; i--) suf[i] = max(suf[i + 1] + V[i], 0);
  int csum = 0;
  int ans = 0;
  for (int i = 1; i <= N; i++) {
    if (V[i] == 0 && csum < 0) {
      ans++;
      csum = D - suf[i];
      if (csum < 0) {
        cout << -1 << endl;
        return 0;
      }
    }
    csum += V[i];
    if (csum > D) {
      cout << -1 << endl;
      return 0;
    }
  }
  cout << ans << endl;
}
