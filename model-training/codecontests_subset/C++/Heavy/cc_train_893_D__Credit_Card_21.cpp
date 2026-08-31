#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 10;
const long long INF = 1e15;
int a[N];
long long sum[N], maxVal[N];
int main() {
  ios_base::sync_with_stdio(0);
  int n, d;
  cin >> n >> d;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    sum[i] = sum[i - 1] + a[i];
  }
  maxVal[n + 1] = -INF;
  for (int i = n; i > 0; i--) {
    maxVal[i] = max(maxVal[i + 1], sum[i]);
  }
  int ans = 0;
  long long deltaSum = 0;
  for (int i = 1; i <= n; i++) {
    if (sum[i] + deltaSum > d) {
      cout << "-1\n";
      return 0;
    }
    if (sum[i] + deltaSum < 0 && a[i] == 0) {
      long long delta = d - (deltaSum + maxVal[i]);
      if (delta < 0) {
        cout << "-1\n";
        return 0;
      }
      if (sum[i] + deltaSum + delta < 0) {
        cout << "-1\n";
        return 0;
      }
      ans++;
      deltaSum += delta;
    }
  }
  cout << ans << "\n";
  return 0;
}
