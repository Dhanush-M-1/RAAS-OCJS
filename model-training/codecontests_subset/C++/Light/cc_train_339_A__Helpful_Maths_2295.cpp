#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  string s, s1;
  cin >> s;
  for (int i = 0; i < s.length(); i = i + 2) {
    s1 = s1 + s[i];
  }
  for (int i = 0; i < s1.length() - 1; i++) {
    for (int j = 0; j < s1.length() - i - 1; j++) {
      if (s1[j] > s1[j + 1]) {
        char temp = s1[j];
        s1[j] = s1[j + 1];
        s1[j + 1] = temp;
      }
    }
  }
  for (int i = 0; i < s1.length(); i++) {
    if (i != s1.length() - 1) {
      cout << s1[i] << "+";
    } else {
      cout << s1[i];
    }
  }
}
