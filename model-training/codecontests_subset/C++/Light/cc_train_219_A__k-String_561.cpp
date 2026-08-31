#include <bits/stdc++.h>
using namespace std;
int main() {
  int k;
  cin >> k;
  string s;
  cin >> s;
  int count[26] = {0};
  for (char x : s) {
    count[x - 'a']++;
  }
  string temp;
  string res;
  bool flag = true;
  for (int i = 0; i < 26; i++) {
    int x = count[i];
    if (x % k != 0) {
      flag = false;
      break;
    } else {
      char y = i + 'a';
      for (int j = 0; j < x / k; j++) {
        temp += y;
      }
    }
  }
  for (int i = 0; i < k; i++) res += temp;
  if (flag)
    cout << res;
  else
    cout << -1;
}
