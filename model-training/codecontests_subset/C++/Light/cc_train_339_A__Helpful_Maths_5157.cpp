#include <bits/stdc++.h>
using namespace std;
int n;
string str, st;
int a[110];
int main() {
  int x = 0;
  cin >> str;
  vector<int> s;
  for (int i = 0; i < str.size(); i++) {
    if (str[i] <= '9' && str[i] >= '0') s.push_back(str[i] - '0');
  }
  sort(s.begin(), s.end());
  cout << s[0];
  for (int i = 1; i < s.size(); i++) cout << "+" << s[i];
  cout << endl;
  return 0;
}
