#include <bits/stdc++.h>
using namespace std;
long long n, N;
int has[3200009], prime[3200009];
void calc(int p) {
  fill(prime + 1, prime + 3200009, 1);
  prime[0] = prime[1] = 0;
  for (int i = 2; i * 1LL * i <= p; i++) {
    if (prime[i]) {
      for (int j = i * i; j <= p; j += i) prime[j] = 0;
    }
  }
}
bool check(long long p) {
  if (p == 0 || p == 1 || p == 2) return true;
  for (int i = 2; i * 1LL * i <= p; i++)
    if (p % i == 0) return false;
  return true;
}
int main() {
  scanf("%I64d", &n);
  N = n;
  if (check(n)) {
    cout << 1 << "\n" << 0;
    return 0;
  }
  int was = 0;
  for (int i = 2; i * 1LL * i <= n; i++) {
    if (!was && n % i == 0) {
      if (check(i) && check(n / i)) {
        cout << 2;
        return 0;
      } else
        break;
    }
  }
  for (int i = 2; i * 1LL * i <= n; i++) {
    if (n % i == 0) {
      while (n % i == 0) n /= i, has[i]++;
    }
  }
  cout << 1 << "\n";
  long long num1 = 0;
  for (int i = 2; i <= 3200000; i++) {
    if (has[i]) {
      if (has[i] >= 2) {
        printf("%I64d", i * 1LL * i);
        return 0;
      }
      if (!num1)
        num1 = i;
      else {
        printf("%I64d", num1 * 1LL * i);
        return 0;
      }
    }
  }
}
