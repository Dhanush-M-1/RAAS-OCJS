#include <bits/stdc++.h>
using namespace std;
int main() {
  int k;
  cin >> k;
  string str;
  cin >> str;
  if (k == 1)
    cout << str;
  else if (str.size() % k != 0)
    cout << -1;
  else {
    map<char, int> hist;
    for (int i = 0; i < str.size(); i++) {
      if (hist.count(str[i]) == 1)
        hist[str[i]]++;
      else
        hist[str[i]] = 1;
    }
    bool valid = true;
    for (auto& pair : hist) {
      if (pair.second % k != 0) {
        valid = false;
        break;
      }
    }
    if (!valid)
      cout << -1;
    else {
      string ans = "";
      while (ans.size() != str.size()) {
        for (auto& pair : hist) ans += string(pair.second / k, pair.first);
      }
      cout << ans;
    }
  }
  return 0;
}
