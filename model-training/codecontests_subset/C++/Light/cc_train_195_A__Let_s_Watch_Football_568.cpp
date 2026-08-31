#include <bits/stdc++.h>
using namespace std;
int solve(int watps, int dowps, int tlength) {
  if (watps <= dowps) return 0;
  int start = 0;
  int end = (watps * tlength) / dowps;
  int res = 0;
  while (start <= end) {
    int mid = start + (end - start) / 2;
    if (watps * tlength == dowps * (tlength + mid))
      return mid;
    else if (watps * tlength < dowps * (tlength + mid)) {
      res = mid;
      end = mid - 1;
    } else
      start = mid + 1;
  }
  return res;
}
int main() {
  int watps, dowps, tlength;
  cin >> watps >> dowps >> tlength;
  int ans = solve(watps, dowps, tlength);
  cout << ans;
}
