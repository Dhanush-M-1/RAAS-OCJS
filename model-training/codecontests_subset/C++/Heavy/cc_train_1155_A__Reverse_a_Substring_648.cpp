#include <bits/stdc++.h>
using namespace std;
long long int gcd(long long int a, long long int b) {
  if (b == 0)
    return a;
  else
    return gcd(b, a % b);
}
string bin(int x) {
  string s = "";
  while (x > 0) {
    if (x % 2)
      s.push_back('1');
    else
      s.push_back('0');
    x = x / 2;
  }
  reverse(s.begin(), s.end());
  return s;
}
int num(string t) {
  reverse(t.begin(), t.end());
  int x = 0;
  for (long long int i = 0; i < t.size(); i++) {
    x = x + pow(2, i) * (t[i] - 48);
  }
  return x;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  std::cout.precision(12);
  int n;
  cin >> n;
  string s;
  cin >> s;
  for (long long int i = 0; i < n - 1; i++) {
    if (s[i] > s[i + 1]) {
      cout << "YES\n";
      cout << i + 1 << " " << i + 2;
      return 0;
    }
  }
  cout << "NO";
}
