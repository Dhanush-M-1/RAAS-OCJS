#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  if (s == "1") {
    cout << "1" << endl;
  } else if (s == "2") {
    cout << "2" << endl;
  } else if (s == "3") {
    cout << "3" << endl;
  } else {
    for (int i = 0; i < s.length() - 2; i += 2) {
      for (int j = 0; j < s.length() - 2; j += 2) {
        if (s[j] > s[j + 2]) {
          swap(s[j], s[j + 2]);
        }
      }
    }
    cout << s << endl;
  }
  return 0;
}
