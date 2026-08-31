#include <bits/stdc++.h>
using namespace std;
static int k;
static string s;
static map<char, int> hashs;
int main() {
  while (cin >> k >> s) {
    hashs.clear();
    for (int i = 0; i < s.length(); i++) hashs[s[i]]++;
    string ans = "";
    bool flag = true;
    int div = -1;
    for (auto it = hashs.begin(); it != hashs.end(); ++it) {
      if (it->second % k != 0) {
        flag = false;
        break;
      } else {
        for (int i = 0; i < it->second / k; i++) ans += it->first;
      }
    }
    if (!flag) {
      printf("-1\n");
    } else {
      for (int i = 0; i < k; i++) cout << ans;
      cout << endl;
    }
  }
  return 0;
}
