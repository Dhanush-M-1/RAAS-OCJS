#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, ltr[30] = {0}, u;
  string s;
  cin >> n;
  cin >> s;
  for (int i = 0; i < s.length(); i++) {
    int p = s[i] - 'a';
    ltr[p]++;
  }
  for (int i = 0; i < 26; i++) {
    if (ltr[i] % n != 0) {
      cout << -1 << endl;
      return 0;
    }
  }
  for (int k = 0; k < n; k++) {
    for (int j = 0; j < 26; j++) {
      if (ltr[j] > 0) {
        for (int i = 0; i < ltr[j] / n; i++) {
          char w = j + 97;
          cout << w;
        }
      }
    }
  }
}
