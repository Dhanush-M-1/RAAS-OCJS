#include <bits/stdc++.h>
using namespace std;
int k;
int c[26] = {0};
int main() {
  cin >> k;
  char ch;
  while (cin >> ch) {
    c[ch - 'a']++;
  }
  for (int i = 0; i <= 25; i++) {
    if (c[i] % k != 0) {
      cout << -1 << endl;
      return 0;
    }
  }
  for (int i = 1; i <= k; i++) {
    for (int j = 0; j <= 25; j++) {
      for (int l = 1; l <= c[j] / k; l++) {
        cout << char('a' + j);
      }
    }
  }
  return 0;
}
