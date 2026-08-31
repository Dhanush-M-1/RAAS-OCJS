#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  int temp = 0;
  cin >> s;
  for (int i = 0; i < s.length(); i++) {
    for (int j = i + 1; j < s.length(); j++) {
      if (s[i] > s[j] && s[j] != '+') {
        temp = s[i];
        s[i] = s[j];
        s[j] = temp;
      }
    }
  }
  cout << s;
}
