#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  int n;
  cin >> s;
  cin >> n;
  for (int i = 0; i < s.length(); i++)
    if (s[i] >= 'A' && s[i] <= 'Z') s[i] += 'a' - 'A';
  for (int i = 0; i < s.length(); i++) {
    char c = s[i];
    if (c < (n + 97)) s[i] -= 'a' - 'A';
  }
  cout << s;
}
