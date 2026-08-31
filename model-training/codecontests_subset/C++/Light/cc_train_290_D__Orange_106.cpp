#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, m, i, j, k, x, y, t;
  string str;
  cin >> str;
  cin >> n;
  for (i = 0; i < str.size(); i++)
    if (isupper(str[i])) str[i] = str[i] - 'A' + 'a';
  for (i = 0; i < str.size(); i++) {
    x = str[i] - 'a';
    if (x < n) str[i] = str[i] - 'a' + 'A';
  }
  cout << str << endl;
}
