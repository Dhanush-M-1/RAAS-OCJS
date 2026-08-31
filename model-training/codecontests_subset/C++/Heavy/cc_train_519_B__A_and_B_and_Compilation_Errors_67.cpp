#include <bits/stdc++.h>
using namespace std;
map<int, int> mp, mpp;
int main() {
std:
  ios_base::sync_with_stdio(false);
  int n, i, ans1, ans2, tmp;
  map<int, int>::iterator it;
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> tmp;
    mp[tmp]++;
  }
  for (i = 0; i < n - 1; i++) {
    cin >> tmp;
    mpp[tmp]++;
    mp[tmp]--;
  }
  for (it = mp.begin(); it != mp.end(); it++) {
    if (it->second == 1) ans1 = it->first;
  }
  for (i = 0; i < n - 2; i++) {
    cin >> tmp;
    mpp[tmp]--;
  }
  for (it = mpp.begin(); it != mpp.end(); it++) {
    if (it->second == 1) ans2 = it->first;
  }
  cout << ans1 << "\n" << ans2 << "\n";
  return 0;
}
