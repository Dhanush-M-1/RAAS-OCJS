#include <bits/stdc++.h>
using namespace std;
int main() {
  string str;
  cin >> str;
  int num;
  cin >> num;
  for (int i = 0; i < str.size(); i++) {
    if (str[i] >= 97 && str[i] <= 122)
      str[i] = str[i];
    else
      str[i] = str[i] + 32;
  }
  for (int i = 0; i < str.size(); i++) {
    if (str[i] >= 97 && str[i] <= 97 + num - 1)
      str[i] = str[i] - 32;
    else
      str[i] = str[i];
  }
  cout << str << endl;
}
