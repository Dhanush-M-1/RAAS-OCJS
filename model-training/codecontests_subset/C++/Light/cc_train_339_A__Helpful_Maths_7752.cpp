#include <bits/stdc++.h>
using namespace std;
int main(void) {
  string s;
  int a;
  char t;
  cin >> s;
  a = s.length();
  if (a == 1) {
    cout << s << endl;
    return 0;
  }
  for (int i = 0; i < a; i = i + 2) {
    for (int j = i + 2; j < a; j = j + 2) {
      if (s[i] > s[j]) {
        t = s[i];
        s[i] = s[j];
        s[j] = t;
      }
    }
  }
  cout << s << endl;
  return 0;
}
