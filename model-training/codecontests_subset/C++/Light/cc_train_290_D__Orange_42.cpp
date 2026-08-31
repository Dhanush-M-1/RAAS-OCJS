#include <bits/stdc++.h>
using namespace std;
int main() {
  string str, res;
  int num;
  int t;
  cin >> str;
  cin >> num;
  for (int i = 0; i < str.size(); i++) {
    if (str[i] <= 'z' && str[i] >= 'a')
      ;
    else
      str[i] -= ('A' - 'a');
  }
  for (int i = 0; i < str.size(); i++) {
    t = str[i];
    if (t < num + 97)
      res += t + 'A' - 'a';
    else
      res += t;
  }
  cout << res;
  return 0;
}
