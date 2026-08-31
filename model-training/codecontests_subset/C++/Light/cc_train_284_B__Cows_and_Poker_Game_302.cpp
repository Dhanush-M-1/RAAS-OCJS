#include <bits/stdc++.h>
using namespace std;
string s;
int a, b, c;
int main() {
  ios_base::sync_with_stdio(false);
  int n;
  cin >> n;
  cin >> s;
  int ans = 0;
  for (int i = 0; i < s.size(); i++) {
    if (s[i] == 'A') a++;
    if (s[i] == 'F') b++;
    if (s[i] == 'I') c++;
  }
  if (c == 0) cout << a << endl;
  if (c == 1) cout << c << endl;
  if (c > 1) cout << "0" << endl;
  return 0;
}
