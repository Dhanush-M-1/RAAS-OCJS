#include <bits/stdc++.h>
using namespace std;
long long fx[] = {1, -1, 0, 0};
long long fy[] = {0, 0, 1, -1};
bool isprime(int n) {
  int i;
  if (n == 1)
    return false;
  else if (n == 2)
    return true;
  for (i = 2; i * i <= n; i++) {
    if (n % i == 0) return false;
  }
  return true;
}
void SieveOE(int n) {
  bool prime[n + 1];
  memset(prime, true, sizeof(prime));
  for (int p = 2; p * p <= n; p++) {
    if (prime[p] == true) {
      for (int i = p * p; i <= n; i += p) prime[i] = false;
    }
  }
  for (int p = 2; p <= n; p++)
    if (prime[p]) cout << p << " ";
}
void dtb(int n) {
  if (n <= 1) {
    printf("%d", n);
  } else {
    dtb(n / 2);
    printf("%d", n % 2);
  }
}
int btd(int n) {
  int num = n, dec_value = 0, base = 1;
  int temp = num;
  while (temp) {
    int last_digit = temp % 10;
    temp = temp / 10;
    dec_value += last_digit * base;
    base = base * 2;
  }
  return dec_value;
}
void printDivisors(int n) {
  for (int i = 1; i <= n; i++)
    if (n % i == 0) cout << i << " ";
}
int smallestDivisor(long long n) {
  if (n % 2 == 0) return 2;
  for (long long i = 3; i * i <= n; i += 2) {
    if (n % i == 0) return i;
  }
  return n;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  ;
  long long r1, r2, c1, c2, d1, d2, a, b, c, d;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  for (a = 1; a <= 9; a++) {
    for (b = 1; b <= 9; b++) {
      for (c = 1; c <= 9; c++) {
        for (d = 1; d <= 9; d++) {
          if (a != b and a != c and a != d and b != c and b != d and c != d) {
            if (a + b == r1 and c + d == r2 and a + d == d1 and b + c == d2 and
                a + c == c1 and b + d == c2) {
              cout << a << " " << b << endl;
              cout << c << " " << d << endl;
              return 0;
            }
          }
        }
      }
    }
  }
  cout << -1 << endl;
}
