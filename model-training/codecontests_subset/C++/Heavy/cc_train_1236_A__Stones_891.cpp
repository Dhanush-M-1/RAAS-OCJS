#include <bits/stdc++.h>
using namespace std;
namespace patch {
template <typename T>
std::string to_string(const T& n) {
  std::ostringstream stm;
  stm << n;
  return stm.str();
}
}  // namespace patch
long long gcd(long long a, long long b) { return a == 0 ? b : gcd(b % a, a); }
bool isAPrime(long long m) {
  for (long long p = 2; p * p <= m; p++) {
    if (m % p == 0) {
      return false;
    }
  }
  return true;
}
bool cmp(int a, int b) { return a > b; }
int main() {
  int n;
  cin >> n;
  while (n--) {
    int a, b, c;
    cin >> a >> b >> c;
    int sum = 0;
    while ((a >= 1 && b >= 2) || (b >= 1 && c >= 2)) {
      sum += 3;
      int k1 = min(b, c / 2);
      int k2 = min(a, b / 2);
      if (k1 > k2) {
        b--;
        c -= 2;
      } else {
        a--;
        b -= 2;
      }
    }
    cout << sum << endl;
  }
}
