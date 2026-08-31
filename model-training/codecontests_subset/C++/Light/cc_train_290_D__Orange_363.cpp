#include <bits/stdc++.h>
using namespace std;
int main() {
  string str;
  cin >> str;
  int n;
  cin >> n;
  int siz = str.size(), i = 0;
  while (i < siz) {
    if (str[i] < 97) {
      str[i] = char(str[i] + 32);
    }
    i++;
  }
  i = 0;
  while (i < siz) {
    if (str[i] < n + 97) {
      str[i] = char(str[i] - 32);
    }
    i++;
  }
  cout << str << endl;
  return 0;
}
