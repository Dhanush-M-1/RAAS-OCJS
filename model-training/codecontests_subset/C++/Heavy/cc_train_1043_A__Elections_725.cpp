#include <bits/stdc++.h>
using namespace std;
long long fastpow(int a, int b, int MOD) {
  long long x = 1, y = a;
  while (b > 0) {
    if (b % 2 == 1) {
      x = (x * y) % MOD;
    }
    y = (y * y) % MOD;
    b /= 2;
  }
  return x;
}
long long InverseEuler(int n, int MOD) { return fastpow(n, MOD - 2, MOD); }
long long f[300000];
int a[99999];
int N;
bool win(int k) {
  int A, B;
  A = 0;
  B = 0;
  for (int i = 0; i < N; i++) {
    A += a[i];
    B += k - a[i];
    if (k < a[i]) return 0;
  }
  if (B > A) return 1;
  return 0;
}
int main() {
  std::ios::sync_with_stdio(false);
  cin >> N;
  for (int i = 0; i < N; i++) cin >> a[i];
  for (int k = 0; k <= 10000000; k++)
    if (win(k)) {
      cout << k << endl;
      return 0;
    }
}
