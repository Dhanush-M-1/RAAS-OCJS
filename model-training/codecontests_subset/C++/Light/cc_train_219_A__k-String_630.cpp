#include <bits/stdc++.h>
using namespace std;
int main() {
  int k;
  string s;
  cin >> k;
  cin >> s;
  vector<int> dic(40);
  int l = s.size();
  for (int i = 0; i < l; i++) {
    dic[s[i] - 'a']++;
  }
  string outStr = "";
  bool flag = true;
  for (int i = 0; i < 40; i++) {
    if (dic[i] % k != 0) {
      flag = false;
      break;
    }
    for (int j = 0; j < dic[i] / k; j++) outStr += i + 'a';
  }
  if (flag)
    for (int i = 0; i < k; i++) cout << outStr;
  else
    cout << "-1";
  return 0;
}
