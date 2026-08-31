#include <bits/stdc++.h>
using namespace std;
long long gcd(long long a, long long b) { return b == 0 ? a : gcd(b, a % b); }
bool is_vowel(char c) {
  c = tolower(c);
  return c == 'a' || c == 'e' || c == 'o' || c == 'i' || c == 'u' || c == 'y';
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int n, x, y;
  cin >> n >> x >> y;
  int res = 0;
  while (100 * x / n < y) x++, res++;
  cout << res;
  return 0;
}
