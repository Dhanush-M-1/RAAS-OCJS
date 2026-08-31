#include <bits/stdc++.h>
using namespace std;
const int MAX_N = 100000;
int n;
int arr[MAX_N];
int prefsum[MAX_N];
int suffmax[MAX_N];
int cap;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> n >> cap;
  for (int i = 0; i < n; i++) cin >> arr[i];
  prefsum[0] = arr[0];
  for (int i = 1; i < n; i++) prefsum[i] = prefsum[i - 1] + arr[i];
  for (int i = 0; i < n; i++) suffmax[i] = -10000000;
  suffmax[n - 1] = prefsum[n - 1];
  for (int i = (n - 1) - 1; i >= 0; i--)
    suffmax[i] = max(suffmax[i + 1], prefsum[i]);
  int add = 0;
  int ans = 0;
  for (int i = 0; i < n; i++) {
    if (prefsum[i] + add > cap) {
      cout << "-1\n";
      return 0;
    }
    if (arr[i] == 0) {
      if (prefsum[i] + add < 0) {
        add += cap - (suffmax[i] + add);
        ans++;
        if (prefsum[i] + add < 0) {
          cout << "-1\n";
          return 0;
        }
      }
    }
  }
  cout << ans << "\n";
}
