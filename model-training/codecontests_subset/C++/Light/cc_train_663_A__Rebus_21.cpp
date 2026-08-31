#include <bits/stdc++.h>
using namespace std;
long long bin_pow(long long a, long long b) {
  if (b == 0) return 1;
  if (b % 2 == 0) {
    long long t = bin_pow(a, b / 2);
    return t * t % 1000000007;
  } else
    return a * bin_pow(a, b - 1) % 1000000007;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  long long a = 1, b = 0, n, g, sum = 0;
  string s = "";
  char c;
  cin >> c;
  s += '+';
  while (true) {
    cin >> c;
    if (c == '+') a++, s += '+';
    if (c == '-') b++, s += '-';
    if (c == '=') break;
  }
  cin >> n;
  if (n <= a * n - b && n >= a - n * b) {
    cout << "Possible\n";
    vector<long long> f;
    for (int i = 0; i < s.size(); i++) {
      if (s[i] == '+')
        g = 1, a--;
      else
        g = -1, b--;
      for (int j = 1; j <= n; j++) {
        if (n - sum - g * j <= a * n - b && n - sum - g * j >= a - n * b) {
          sum += g * j, f.push_back(j);
          break;
        }
      }
    }
    cout << f[0] << " ";
    for (int i = 1; i < s.size(); i++) cout << s[i] << " " << f[i] << " ";
    cout << "= " << n;
  } else
    cout << "Impossible";
  return 0;
}
