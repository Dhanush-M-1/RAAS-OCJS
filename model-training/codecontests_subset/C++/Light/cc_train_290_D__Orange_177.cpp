#include <bits/stdc++.h>
using namespace std;
int main() {
  string str, a;
  int nr;
  cin >> str >> nr;
  transform(str.begin(), str.end(), str.begin(), ::tolower);
  for (int i = 0; i < str.size(); ++i)
    if ((int)str[i] < nr + 97)
      a += str[i] - 'a' + 'A';
    else
      a += str[i];
  cout << a;
  return 0;
}
