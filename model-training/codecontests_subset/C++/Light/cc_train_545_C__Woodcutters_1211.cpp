#include <bits/stdc++.h>
using namespace std;
int main() {
  long n, x, h;
  cin >> n;
  vector<pair<long, long>> arr;
  for (int i = 0; i < n; i++) {
    cin >> x >> h;
    arr.push_back({x, h});
  }
  long ans = 0, maxd = -3e9;
  for (int i = 0; i < n; i++) {
    long x = arr[i].first;
    long h = arr[i].second;
    if (x - h > maxd) {
      maxd = x;
      ans++;
      continue;
    }
    if (i == n - 1) {
      ans++;
      continue;
    }
    if (x + h < arr[i + 1].first) {
      ans++;
      maxd = x + h;
      continue;
    }
    maxd = x;
  }
  cout << ans << "\n";
  return 0;
}
