#include <bits/stdc++.h>
using namespace std;
vector<char> ans;
int main() {
  int a = 0, b = 0, c = 0;
  string s;
  cin >> s;
  for (int i = 0; i < s.size(); i += 2) {
    if (s[i] == '1') a++;
    if (s[i] == '2') b++;
    if (s[i] == '3') c++;
  }
  for (int i = 0; i < a; i++) {
    ans.push_back('+');
    ans.push_back('1');
  }
  for (int i = 0; i < b; i++) {
    ans.push_back('+');
    ans.push_back('2');
  }
  for (int i = 0; i < c; i++) {
    ans.push_back('+');
    ans.push_back('3');
  }
  for (int i = 1; i < ans.size(); i++) cout << ans[i];
  return 0;
  return 0;
}
