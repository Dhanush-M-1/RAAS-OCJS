#include <bits/stdc++.h>
using namespace std;
int main() {
  string str;
  getline(cin, str);
  int len = str.length();
  for (int i = 0; i < len; i += 2) {
    for (int j = i + 2; j < len; j += 2) {
      if (str.at(i) > str.at(j)) {
        swap(str.at(i), str.at(j));
      }
    }
  }
  for (int i = 0; i < str.length(); i++) {
    cout << str.at(i);
  }
  return 0;
}
