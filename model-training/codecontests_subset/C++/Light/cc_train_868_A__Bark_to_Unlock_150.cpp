#include <bits/stdc++.h>
using namespace std;
int32_t main() {
  string str;
  cin >> str;
  int cntf[26];
  int cntl[26];
  memset(cntf, 0, sizeof cntf);
  memset(cntl, 0, sizeof cntl);
  int n;
  cin >> n;
  bool check = false;
  while (n--) {
    string s;
    cin >> s;
    if (s == str) check = true;
    cntf[(s[0] - 'a')] = 1;
    cntl[(s[1] - 'a')] = 1;
  }
  if (check)
    cout << "YES";
  else {
    int k1 = (str[0] - 'a');
    int k2 = (str[1] - 'a');
    if (cntl[k1] == 1 && cntf[k2] == 1)
      cout << "YES";
    else
      cout << "NO";
  }
  return 0;
}
