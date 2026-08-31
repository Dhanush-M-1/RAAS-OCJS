#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i;
  string s;
  cin >> s;
  scanf("%d", &n);
  for (i = 0; i < s.length(); i++) {
    if (s[i] < 97) s[i] += 32;
    if (s[i] < 'a' + n) s[i] -= 32;
  }
  cout << s << "\n";
  return 0;
}
