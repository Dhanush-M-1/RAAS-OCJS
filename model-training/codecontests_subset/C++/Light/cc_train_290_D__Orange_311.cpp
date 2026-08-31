#include <bits/stdc++.h>
using namespace std;
int main() {
  char s[55];
  int b;
  cin >> s;
  cin >> b;
  int len = strlen(s);
  for (int i = 0; i < len; i++) {
    if (s[i] < 'a') {
      s[i] += 32;
    }
  }
  for (int i = 0; i < len; i++) {
    if (s[i] < b + 'a') {
      s[i] -= 32;
    }
  }
  cout << s << endl;
  return 0;
}
