#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  string st;
  cin >> st;
  map<int, int> mp;
  for (int i = 0; i < n; i++) {
    mp[(int)st[i] - 48]++;
  }
  if (mp[8] == 0) {
    cout << 0 << endl;
    return 0;
  }
  int s = 0, e = mp[8];
  for (int i = 0; i < 10; i++) s += mp[i];
  s /= 11;
  if (e >= s)
    cout << s << endl;
  else
    cout << e << endl;
  return 0;
}
