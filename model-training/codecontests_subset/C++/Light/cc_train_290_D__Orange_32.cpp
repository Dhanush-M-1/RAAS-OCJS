#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i;
  string str;
  cin >> str >> n;
  for (i = 0; i < str.size(); i++) {
    if (tolower(str[i]) < n + 97) {
      str[i] = toupper(str[i]);
    } else
      str[i] = tolower(str[i]);
  }
  cout << str;
}
