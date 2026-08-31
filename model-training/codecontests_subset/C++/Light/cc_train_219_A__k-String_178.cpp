#include <bits/stdc++.h>
using namespace std;
int main() {
  int k;
  string s;
  map<char, int> m1;
  cin >> k >> s;
  int n = s.length();
  for (int i = 0; i < n; i++) {
    m1[s[i]]++;
  }
  map<char, int>::iterator it;
  int flag = 0;
  for (it = m1.begin(); it != m1.end(); it++) {
    if ((it->second) % k) {
      flag = 1;
      break;
    }
  }
  if (flag) {
    cout << "-1";
  } else {
    it = m1.begin();
    int val = k;
    string s1 = "";
    for (it = m1.begin(); it != m1.end(); it++) {
      int num = (it->second) / k;
      while (num--) s1 += it->first;
    }
    while (k--) cout << s1;
  }
  return 0;
}
