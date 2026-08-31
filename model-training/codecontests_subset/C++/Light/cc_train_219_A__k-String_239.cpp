#include <bits/stdc++.h>
using namespace std;
int main() {
  int k;
  cin >> k;
  string s1;
  cin >> s1;
  std::vector<int> v(26, 0);
  for (int i = 0; i < s1.length(); i++) {
    v[s1[i] - 97]++;
  }
  bool flag = false;
  for (int i = 0; i < 26; i++) {
    if (v[i] % k != 0) {
      flag = true;
      break;
    }
  }
  if (flag) {
    cout << "-1";
  } else {
    for (int i = 0; i < k; i++) {
      for (int j = 0; j < 26; j++) {
        if (v[j] != 0) {
          for (int l = 0; l < v[j] / k; l++) {
            cout << char(97 + j);
          }
        }
      }
    }
  }
}
