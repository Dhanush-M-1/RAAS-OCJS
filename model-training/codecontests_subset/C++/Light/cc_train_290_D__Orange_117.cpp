#include <bits/stdc++.h>
using namespace std;
int main() {
  string str, str1, str2;
  int c, n, i;
  cin >> str >> c;
  n = str.size();
  for (i = 0; i < n; i++) {
    if (str[i] >= 'A' && str[i] <= 'Z')
      str1.push_back(str[i] - 'A' + 'a');
    else
      str1.push_back(str[i]);
  }
  for (i = 0; i < n; i++)
    if (str1[i] >= c + 97)
      str2.push_back(str1[i]);
    else
      str2.push_back(str1[i] - 32);
  cout << str2;
}
