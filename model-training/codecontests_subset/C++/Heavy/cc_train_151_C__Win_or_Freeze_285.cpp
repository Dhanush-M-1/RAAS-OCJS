#include <bits/stdc++.h>
using namespace std;
bool check(long long x) {
  long long s = (long long)sqrt(x + .0);
  for (long long i = 2; i <= s + 10 && i < x; i++)
    if (x % i == 0) return 0;
  return 1;
}
int main() {
  long long n;
  cin >> n;
  if (check(n) || n == 2) {
    printf("1\n0\n");
    return 0;
  }
  long long x = n;
  long long s = (long long)sqrt(x + .0);
  int cnt = 0;
  for (int i = 2; i <= s && i < n; i++) {
    while (x % i == 0) {
      x /= i;
      cnt++;
    }
  }
  if (x > 1) cnt++;
  if (cnt == 2) {
    printf("2\n");
    return 0;
  }
  cout << 1 << endl;
  x = n;
  cnt = 0;
  long long p = 1;
  for (int i = 2; i <= s && i < n; i++)
    while (x % i == 0) {
      x /= i;
      p *= i;
      cnt++;
      if (cnt == 2) {
        cout << p << endl;
        return 0;
      }
    }
  if (x > 1) {
    cnt++;
    if (cnt == 2) {
      p = p * x;
      cout << p << endl;
    }
  }
  return 0;
}
