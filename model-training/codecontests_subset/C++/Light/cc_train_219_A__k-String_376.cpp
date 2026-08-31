#include <bits/stdc++.h>
using namespace std;
int main() {
  int k;
  cin >> k;
  string s;
  cin >> s;
  map<char, int> mp;
  for (int i = 0; i < s.size(); i++) {
    mp[s[i]]++;
  }
  bool b = true;
  string res = "";
  for (map<char, int>::iterator it = mp.begin(); it != mp.end(); it++) {
    if ((*it).second % k != 0) {
      b = false;
      break;
    } else
      for (int j = 0; j < (*it).second / k; j++) res += (*it).first;
  }
  if (b) {
    for (int i = 0; i < k; i++) cout << res;
    cout << endl;
  } else
    cout << -1 << endl;
  return 0;
}
