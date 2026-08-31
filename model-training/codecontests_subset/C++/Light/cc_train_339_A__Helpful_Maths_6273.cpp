#include <bits/stdc++.h>
using namespace std;
int main() {
  string str;
  cin >> str;
  vector<int> a;
  for (int i = 0; i < str.size(); i++)
    if (str[i] != '+') a.push_back(str[i] - 48);
  sort(a.begin(), a.end());
  int j = 0;
  for (int i = 0; i < a.size(); i++) {
    str[j] = a[i] + 48;
    j += 2;
  }
  cout << str;
  return 0;
}
