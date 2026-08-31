#include <bits/stdc++.h>

using namespace std;

long long gcd(long long a, long long b) {
  return !b ? a : gcd(b, a % b);
}

bool check(long long l, long long r, long long a, long long b) {
  b %= a;
  l += a - b, r += a - b;
  return r / a > (l - 1) / a;
}

int main() {
  int T;
  cin >> T;
  while (T--) {
    long long A, B, C, D;
    cin >> A >> B >> C >> D;
    puts(A < B || B > D || check(C + 1, B - 1, gcd(B, D), A) ? "No" : "Yes");
  }
  return 0;
}
