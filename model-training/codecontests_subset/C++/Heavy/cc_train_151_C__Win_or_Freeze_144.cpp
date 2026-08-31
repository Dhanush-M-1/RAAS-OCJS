#include <bits/stdc++.h>
using namespace std;
bool isPrime(long long n) {
  for (long long i = 2; i * i <= n; i++) {
    if (n % i == 0) return false;
  }
  return true;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long n;
  cin >> n;
  if (isPrime(n)) {
    cout << 1 << endl << 0 << endl;
  } else {
    long long a = -1, b = -1;
    long long temp = n;
    for (long long i = 2; i <= n; i++) {
      if (n % i == 0) {
        if (isPrime(i) && isPrime(n / i) && (n == temp)) {
          a = i;
          b = n / i;
        } else {
          if (a == -1)
            a = i;
          else if (b == -1)
            b = i;
          n /= i;
          while ((n % i) == 0) {
            if (b == -1) b = i;
            n /= i;
          }
        }
      }
      if (a != -1 && b != -1) break;
    }
    if ((a * b) == temp) {
      cout << 2 << endl;
    } else {
      cout << 1 << endl;
      cout << a * b << endl;
    }
  }
  return 0;
}
