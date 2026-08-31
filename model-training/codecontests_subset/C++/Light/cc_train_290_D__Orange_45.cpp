#include <bits/stdc++.h>
using namespace std;
void toLower(string& str) {
  int offset = 'a' - 'A';
  for (int i = 0; i < str.length(); i++) {
    char c = str[i];
    if ('A' <= c && c <= 'Z') {
      str[i] = c + offset;
    }
  }
}
int main() {
  string str;
  int x;
  cin >> str >> x;
  toLower(str);
  string res = "";
  int n = str.length();
  int offset = 'A' - 'a';
  for (int i = 0; i < n; i++) {
    int c = str[i];
    if (c < x + 97) {
      res += (c + offset);
    } else {
      res += c;
    }
  }
  cout << res << endl;
}
