#include <bits/stdc++.h>
using namespace std;
int main() {
  string str;
  int n;
  cin >> str >> n;
  for (int i = 0; i < str.size(); ++i) {
    if (str[i] >= 'A' && str[i] <= 'Z') {
      if (str[i] - 'A' >= n) str[i] = str[i] - 'A' + 'a';
    } else {
      if (str[i] - 'a' < n) str[i] = str[i] - 'a' + 'A';
    }
  }
  cout << str;
  return 0;
}
