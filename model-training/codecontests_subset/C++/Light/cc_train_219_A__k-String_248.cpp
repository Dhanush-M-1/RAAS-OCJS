#include <bits/stdc++.h>
using namespace std;
int k, a[1012];
string s, r;
string operator*(string s, int n) {
  string cs = s;
  while (--n) s += cs;
  return s;
}
int main() {
  cin >> k >> s;
  for (int i = 0; i < s.length(); i++) a[s[i]]++;
  for (int i = 'a'; i <= 'z'; i++)
    if (a[i] % k) {
      cout << -1 << endl;
      return 0;
    } else
      r.insert(r.length(), a[i] /= k, char(i));
  cout << r * k << endl;
}
