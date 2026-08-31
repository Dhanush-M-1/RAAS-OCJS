#include <bits/stdc++.h>
const double pi = 3.1415926535897932384626433832795;
double EPS = 10e-6;
const int INF = 2000000000;
long long gcd(long long a, long long b) {
  if (a == 0) return b;
  return gcd(b % a, a);
}
using namespace std;
void ifd() {}
void tme() {}
string s, ans;
int n;
int main() {
  ifd();
  cin >> s >> n;
  for (int i = (0); i < (s.size()); ++i)
    if (s[i] >= 'A' && s[i] <= 'Z') s[i] += 32;
  for (int i = (0); i < (s.size()); ++i) {
    if ((int)(s[i]) < n + 97) {
      ans += (s[i] - 32);
    } else {
      ans += s[i];
    }
  }
  cout << ans << endl;
  tme();
  return 0;
}
