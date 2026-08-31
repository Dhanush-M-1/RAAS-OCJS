#include <bits/stdc++.h>
using namespace std;
long long gcd(long long x, long long y) {
  if (x == 0) return y;
  return (gcd(y % x, x));
}
string Tolower(string s) {
  transform(s.begin(), s.end(), s.begin(), ::tolower);
  return s;
}
string Toupper(string s) {
  transform(s.begin(), s.end(), s.begin(), ::toupper);
  return s;
}
void solve() {
  long long k, l, i, j, c[26] = {0};
  string s, w = "";
  cin >> k;
  cin >> s;
  l = s.length();
  for (long long i = 0; i < l; i++) {
    c[s[i] - 97]++;
  }
  for (long long i = 0; i < l; i++) {
    if (c[s[i] - 97] % k != 0 || l % k != 0) {
      cout << -1;
      return;
    }
  }
  for (long long i = 0; i < 26; i++) {
    if (c[i] != 0)
      for (long long j = 0; j < c[i] / k; j++) w += (char)(i + 97);
  }
  for (long long i = 0; i < k; i++) cout << w;
  return;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  solve();
  return 0;
}
