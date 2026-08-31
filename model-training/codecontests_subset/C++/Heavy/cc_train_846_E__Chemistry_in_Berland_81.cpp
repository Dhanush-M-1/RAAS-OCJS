#include <bits/stdc++.h>
using namespace std;
using LL = long long;
constexpr int N = 1e5 + 5;
constexpr LL INF = 2e17;
LL have[N], need[N];
int x[N], k[N];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  int n;
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> have[i];
  for (int i = 1; i <= n; i++) cin >> need[i];
  for (int i = 2; i <= n; i++) cin >> x[i] >> k[i];
  for (int i = n; i > 1; i--) {
    if (have[i] < need[i]) {
      LL v = need[i] - have[i];
      if ((__int128)v * k[i] > INF) {
        cout << "NO\n";
        return 0;
      }
      have[x[i]] -= (need[i] - have[i]) * k[i];
      have[i] = need[i];
    }
    if (have[i] > need[i]) {
      have[x[i]] += have[i] - need[i];
    }
    if (have[x[i]] < -INF) {
      cout << "NO\n";
      return 0;
    }
  }
  if (have[1] < need[1])
    cout << "NO\n";
  else
    cout << "YES\n";
}
