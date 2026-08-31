#include <bits/stdc++.h>
const long long N = 1e6 + 7;
using namespace std;
long long n, m, x, y, a[N], b[N];
string s;
int main() {
  cin >> s;
  for (int i = 0; i < s.length(); i++)
    if (s[i] > 'z' || s[i] < 'a') s[i] = s[i] + 'e' - 'E';
  cin >> n;
  for (int i = 0; i < s.length(); i++)
    if (s[i] < 'a' + n && s[i] >= 'a') s[i] = s[i] + 'E' - 'e';
  cout << s;
  return 0;
}
