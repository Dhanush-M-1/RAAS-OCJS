#include <bits/stdc++.h>
using namespace std;
long long inf = 1e15;
long long mod = 1e9 + 7;
string ITS(long long x) {
  string s = "";
  while (x > 0) {
    s += (char)(x % 10 + '0');
    x /= 10;
  }
  string t = "";
  for (int i = s.size() - 1; i > -1; i--) t += s[i];
  return t;
}
long long bmm(long long a, long long b) {
  if (a == 0) return b;
  return bmm(b % a, a);
}
bool aval(long long x) {
  if (x < 2) return 0;
  if (x < 4) return 1;
  for (long long i = 2; i * i <= x; i++)
    if (x % i == 0) return 0;
  return 1;
}
long long power(long long p, long long t) {
  if (t == 0) return 1;
  long long x = power(p, t / 2);
  if (t % 2)
    return x * x * p;
  else
    return x * x;
}
const long long M = 1e2 + 5;
int main() {
  std::ios::sync_with_stdio(false);
  string s, t;
  cin >> s >> t;
  long long n;
  cin >> n;
  cout << s << ' ' << t << '\n';
  for (long long i = 0; i < n; i++) {
    string u, v;
    cin >> u >> v;
    if (s == u)
      s = v;
    else if (t == u)
      t = v;
    cout << s << ' ' << t << '\n';
  }
}
