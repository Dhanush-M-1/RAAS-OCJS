#include <bits/stdc++.h>
using namespace std;
int freq[300];
int main() {
  bool l = false;
  char c;
  int k, i;
  string s;
  string substring = "";
  cin >> k >> s;
  for (i = 0; i < s.length(); i++) ++freq[s[i]];
  for (c = 'a'; c <= 'z'; c++) {
    if (freq[c] % k != 0) {
      l = true;
      break;
    }
    for (i = 0; i < freq[c] / k; i++) substring += c;
  }
  if (l == false) {
    while (k--) cout << substring;
  } else
    cout << -1 << endl;
  return 0;
}
