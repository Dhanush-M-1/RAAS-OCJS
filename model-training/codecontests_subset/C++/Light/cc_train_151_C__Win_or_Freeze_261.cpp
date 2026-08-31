#include <bits/stdc++.h>
using namespace std;
int a[111111], cnt;
int main() {
  long long n;
  cin >> n;
  for (long long i = 2; i * i <= n; ++i)
    if (n % i == 0)
      while (n % i == 0) {
        a[++cnt] = i;
        n /= i;
      }
  if (n != 1) a[++cnt] = n;
  if (cnt < 2)
    cout << "1\n0";
  else if (cnt == 2)
    cout << "2";
  else
    cout << "1\n" << a[2] * a[1];
  return 0;
}
