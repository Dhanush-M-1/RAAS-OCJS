#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n;
  long long a;
  map<long long, int> mp[3];
  cin >> n;
  for (int j = 0; j < 3; j++) {
    for (int(i) = 0; (i) < (n - j); (i)++) {
      cin >> a;
      mp[j][a]++;
    }
  }
  for (int(i) = 0; (i) < (2); (i)++) {
    for (auto j : mp[i]) {
      if (mp[i][j.first] != mp[i + 1][j.first]) {
        cout << j.first << endl;
        break;
      }
    }
  }
  return 0;
}
