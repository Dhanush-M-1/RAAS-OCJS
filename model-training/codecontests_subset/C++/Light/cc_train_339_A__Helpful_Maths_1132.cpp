#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  string s;
  cin >> s;
  int count1 = 0, count2 = 0, count3 = 0;
  for (int i = 0; i < s.size(); i++) {
    if (s[i] == '1') {
      count1++;
    } else if (s[i] == '2') {
      count2++;
    } else {
      if (s[i] == '3') {
        count3++;
      }
    }
  }
  string c;
  while (count1-- > 0) {
    c += "1+";
  }
  while (count2-- > 0) {
    c += "2+";
  }
  while (count3-- > 0) {
    c += "3+";
  }
  int n = c.size();
  cout << c.substr(0, n - 1);
  return 0;
}
