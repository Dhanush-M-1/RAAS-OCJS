#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  string s, ans;
  cin >> s;
  scanf("%d", &n);
  for (int i = 0; i < s.size(); i++)
    if (s[i] >= 'A' && s[i] <= 'Z') s[i] = s[i] - 'A' + 'a';
  for (int i = 0; i < s.size(); i++) {
    char c = s[i];
    if (c < n + 97)
      ans += c - 'a' + 'A';
    else
      ans += c;
  }
  cout << ans;
  return 0;
}
