#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int alphabet[26] = {0};
  int key = 0, flag = 1;
  cin >> key;
  string s;
  cin >> s;
  for (int i = 0; s[i] != 0; i++) {
    alphabet[s[i] - 97]++;
  }
  for (int i = 0; i < 26; i++) {
    if (alphabet[i] % key != 0) {
      cout << -1 << endl;
      flag = 0;
      break;
    }
  }
  if (flag) {
    for (int i = 0; i < key; i++) {
      for (int j = 0; j < 26; j++) {
        if (alphabet[j] > 0) {
          for (int k = 0; k < alphabet[j] / key; k++) cout << char(97 + j);
        }
      }
    }
  }
  cout << endl;
  return 0;
}
