#include <bits/stdc++.h>
using namespace std;
int main() {
  int k;
  cin >> k;
  string s;
  cin >> s;
  int c1 = 0;
  int a[26] = {0};
  for (int i = 0; i < s.length(); i++) {
    a[s[i] - 'a']++;
  }
  for (int i = 0; i < 26; i++) {
    if (a[i] > 0) {
      if (a[i] % k != 0) {
        cout << "-1" << endl;
        c1 = 1;
        break;
      }
    }
  }
  string res = "";
  if (c1 == 0) {
    for (int i = 0; i < 26; i++) {
      int temp = a[i] / k;
      for (int j = 0; j < temp; j++) {
        char temp = i + 97;
        res += temp;
      }
    }
  }
  string res1 = "";
  while (k--) {
    res1 += res;
  }
  cout << res1 << endl;
  return 0;
}
