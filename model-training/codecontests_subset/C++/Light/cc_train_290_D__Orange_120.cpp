#include <bits/stdc++.h>
using namespace std;
int main() {
  string str;
  int n;
  cin >> str;
  cin >> n;
  int size;
  size = str.size();
  for (int i = 0; i < size; i++) {
    str[i] = tolower(str[i]);
  }
  for (int i = 0; i < size; i++) {
    char x;
    x = str[i];
    if (97 + n > x) {
      x = toupper(x);
    } else {
      x = tolower(x);
    }
    cout << x;
  }
  return 0;
}
