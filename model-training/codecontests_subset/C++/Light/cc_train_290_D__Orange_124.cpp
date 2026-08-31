#include <bits/stdc++.h>
using namespace std;
string s, ans;
int n;
int main() {
  cin >> s;
  scanf("%d", &n);
  for (int i = 0; i < s.size(); i++) {
    if (s[i] < 'a') s[i] = 'a' + (s[i] - 'A');
  }
  for (int i = 0; i < s.size(); i++) {
    char c = s[i];
    if (c < 97 + n)
      ans.push_back('A' + (c - 'a'));
    else
      ans.push_back(c);
  }
  printf("%s", ans.c_str());
  return 0;
}
