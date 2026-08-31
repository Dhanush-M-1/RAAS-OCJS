#include <bits/stdc++.h>
using namespace std;
long long int exp(long long int x, long long int y) {
  if (y == 0) return 1;
  if (y == 1) return x;
  if (y % 2 == 0)
    return exp(x, y / 2) * exp(x, y / 2);
  else
    return x * exp(x, y / 2) * exp(x, y / 2);
}
long long int gcd(long long int a, long long int b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
long long int lcm(long long int a, long long int b) {
  return (a * b) / gcd(a, b);
}
int l;
long long int fact(long long int x) {
  if (x == 1)
    return 1;
  else
    return x * fact(x - 1);
}
bool isPrime(int x) {
  int ans = 0;
  for (int i = 2; i <= sqrt(x); ++i) {
    if (x % i == 0) {
      ans = 1;
      i = x;
    }
  }
  if (ans == 0)
    return true;
  else
    return false;
}
void solve() {
  string s;
  cin >> s;
  vector<int> v;
  for (int i = 0; i < s.length(); ++i) {
    if (s[i] != '+') v.push_back((int)s[i] - '0');
  }
  sort(v.begin(), v.end());
  for (int i = 0; i < v.size(); ++i) {
    if (i == v.size() - 1)
      cout << v[i];
    else
      cout << v[i] << "+";
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  solve();
}
