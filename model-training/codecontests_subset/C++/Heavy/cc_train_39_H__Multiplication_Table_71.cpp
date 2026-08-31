#include <bits/stdc++.h>
using namespace std;
int conversion(string p) {
  int o;
  o = atoi(p.c_str());
  return o;
}
string toString(int h) {
  stringstream ss;
  ss << h;
  return ss.str();
}
long long gcd(long long a, long long b) { return (b == 0 ? a : gcd(b, a % b)); }
long long lcm(long long a, long long b) { return (a * (b / gcd(a, b))); }
long long toi(string p) {
  long long x;
  istringstream in(p);
  in >> x;
  return x;
}
int k, mul = 1, lab[11][11];
string go(int n) {
  string ans = "";
  while (n / k > 0) {
    ans += toString(n % k);
    n /= k;
  }
  ans += toString(n % k);
  reverse(ans.begin(), ans.end());
  return ans;
}
int main() {
  for (int i = 1; i <= 10; i++) {
    for (int j = 1; j <= 10; j++) {
      lab[i][j] = j * mul;
    }
    mul++;
  }
  while (cin >> k) {
    for (int i = 1; i <= k - 1; i++) {
      for (int j = 1; j <= k - 1; j++) {
        cout << go(lab[i][j]) << " ";
      }
      cout << endl;
    }
  }
}
