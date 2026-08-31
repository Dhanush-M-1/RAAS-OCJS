#include <bits/stdc++.h>
using namespace std;
bool prime[10000005] = {1, 1};
long long p[10000005] = {0};
long long num[105];
void get_prime() {
  int i, j;
  for (i = 2; i * i <= 10000005; i++)
    if (!prime[i])
      for (j = 2 * i; j < 10000005; j += i) prime[j] = 1;
  for (i = 2; i < 10000005; i++)
    if (!prime[i]) p[++p[0]] = i;
  return;
}
int fenjie(long long n) {
  int res = 0, i;
  for (i = 1; i <= p[0] & p[i] * p[i] <= n; i++)
    while (n % p[i] == 0) {
      num[res++] = p[i];
      n /= p[i];
    }
  if (n > 1) num[res++] = n;
  return res;
}
int main() {
  get_prime();
  long long n, res;
  int i, many;
  while (cin >> n) {
    many = fenjie(n);
    if (many > 2) {
      cout << 1 << endl;
      res = 1;
      for (i = 0; i < 2; i++) res *= num[i];
      cout << res << endl;
    } else if (many == 2)
      cout << 2 << endl;
    else
      cout << 1 << endl << 0 << endl;
  }
  return 0;
}
