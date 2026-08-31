#include <bits/stdc++.h>
using namespace std;
const int MOD = 1e9 + 7;
const long double PI = 4 * atan((long double)1);
long long power(long long a, long long n) {
  long long res = 1;
  while (n) {
    if (n % 2) res *= a;
    a *= a;
    n /= 2;
  }
  return res;
}
long long int h = power(10, 10);
string bin(int n, int k) {
  string t, s;
  while (n != 0) {
    int x = n % k;
    char a = x + '0';
    n = n / k;
    t = t + a;
  }
  for (int i = t.size() - 1; i >= 0; i--) s = s + t[i];
  return s;
}
int main() {
  int n;
  cin >> n;
  for (int i = 1; i < n; i++) {
    for (int j = 1; j < n; j++) {
      string as = bin(i * j, n);
      cout << as << " ";
    }
    cout << "\n";
  }
  return 0;
}
