#include <bits/stdc++.h>
using namespace std;
int main() {
  int j, n, c = 0, flag = 0;
  string s;
  cin >> n;
  cin >> s;
  map<char, int> freq;
  for (j = 0; j < s.length(); j++) {
    freq[s[j]]++;
  }
  for (auto i : freq) {
    if (i.second % n != 0) {
      flag = 1;
      break;
    }
  }
  if (flag == 1) {
    cout << -1;
  } else {
    string r = "";
    j = 0;
    for (auto i : freq) {
      while (j < (i.second) / n) {
        r = r + i.first;
        j++;
      }
      j = 0;
    }
    for (int i = 0; i < n; i++) {
      cout << r;
    }
  }
  return 0;
}
