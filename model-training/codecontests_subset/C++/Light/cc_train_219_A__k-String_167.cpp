#include <bits/stdc++.h>
using namespace std;
int alpha[28];
int main() {
  int k;
  memset(alpha, 0, sizeof(alpha));
  string s;
  cin >> k;
  cin >> s;
  for (int i = 0; s[i]; i++) {
    alpha[s[i] - 'a']++;
  }
  string tex = "";
  for (int i = 0; i < 28; i++) {
    if (alpha[i] % k != 0 && alpha[i] != 0) {
      cout << -1;
      return 0;
    }
    if (alpha[i] % k == 0) {
      for (int j = 0; j < alpha[i] / k; j++) tex += i + 'a';
    }
  }
  for (int i = 0; i < k; i++) cout << tex;
  return 0;
}
