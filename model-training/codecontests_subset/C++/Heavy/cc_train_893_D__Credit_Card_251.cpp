#include <bits/stdc++.h>
using namespace std;
const long long int INF = 1000000007;
const int N = 1000000 + 7;
long long int trans[N];
long long int ca[N];
long long int maxb[N];
int main() {
  std::ios::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  long long int d;
  cin >> n >> d;
  for (int i = 0; i < n; i++) cin >> trans[i];
  ca[0] = trans[0];
  for (int i = 1; i < n; i++) ca[i] = ca[i - 1] + trans[i];
  maxb[n] = LLONG_MIN / 2;
  for (int i = n - 1; i >= 0; i--) maxb[i] = max(ca[i], maxb[i + 1]);
  long long int currentAdd = 0;
  int ans = 0;
  for (int i = 0; i < n; i++) {
    ca[i] += currentAdd;
    if (ca[i] > d) {
      cout << -1 << endl;
      return 0;
    }
    if (trans[i] == 0) {
      if (ca[i] < 0) {
        long long int all = d - (maxb[i + 1] + currentAdd);
        if (ca[i] + all > d) {
          all = d - ca[i];
        }
        ca[i] += all;
        currentAdd += all;
        if (ca[i] < 0) {
          cout << -1 << endl;
          return 0;
        }
        ans++;
      }
    }
  }
  cout << ans << endl;
  return 0;
}
