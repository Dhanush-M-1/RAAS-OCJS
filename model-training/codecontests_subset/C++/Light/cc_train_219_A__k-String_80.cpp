#include <bits/stdc++.h>
using namespace std;
int a[27];
int main() {
  int k;
  string s, q = "";
  cin >> k >> s;
  for (int i = 0; i < s.size(); i++) {
    a[s[i] - 'a']++;
  }
  for (int i = 0; i < 26; i++) {
    if (a[i] % k != 0) {
      cout << -1;
      return 0;
    }
    for (int j = 1; j <= a[i] / k; j++) {
      q += i + 'a';
    }
  }
  for (int i = 1; i <= k; i++) {
    cout << q;
  }
  return 0;
}
