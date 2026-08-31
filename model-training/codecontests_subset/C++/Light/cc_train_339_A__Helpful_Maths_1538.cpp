#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  char temp;
  cin >> s;
  for (int x = 0; x < s.length(); x += 2) {
    for (int y = 0; y < s.length(); y += 2) {
      if (s[x] < s[y]) {
        temp = s[x];
        s[x] = s[y];
        s[y] = temp;
      }
    }
  }
  cout << s;
  return 0;
}
