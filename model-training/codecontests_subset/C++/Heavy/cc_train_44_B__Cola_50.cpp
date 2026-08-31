#include <bits/stdc++.h>
using namespace std;
map<int, int> mp;
vector<int> tz;
map<int, int>::iterator mt;
int main() {
  int ans = 0;
  int n, a, b, c;
  cin >> n >> a >> b >> c;
  int x, y, z = 0;
  n = 2 * n;
  for (x = 0; x <= a; ++x)
    for (y = 0; y <= b; ++y) mp[x + 2 * y]++;
  int sz = mp.size();
  int arr1[sz], cnt[sz];
  int i = 0;
  for (mt = mp.begin(); mt != mp.end(); mt++) {
    arr1[i] = (*mt).first;
    cnt[i] = (*mt).second;
    i++;
  }
  for (z = 0; z <= c; z++) tz.push_back(n - 4 * z);
  for (int j = 0; j < (int)tz.size(); j++) {
    int num = tz[j];
    int id = -1;
    int left = 0, right = i - 1, middle;
    while (left <= right) {
      middle = (left + right) / 2;
      if (arr1[middle] == num) {
        id = middle;
        break;
      } else if (arr1[middle] < num) {
        left = middle + 1;
      } else {
        right = middle - 1;
      }
    }
    if (id != -1) ans += cnt[id];
  }
  cout << ans << endl;
  return 0;
}
