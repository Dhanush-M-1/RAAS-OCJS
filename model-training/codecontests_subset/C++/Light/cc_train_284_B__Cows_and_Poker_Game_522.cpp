#include <bits/stdc++.h>
long long gcd(long long a, long long b) { return b ? gcd(b, a % b) : a; }
using namespace std;
char str[300008];
int main() {
  int t;
  cin >> t;
  cin >> str;
  int i, ci = 0, ca = 0, cf = 0;
  for (i = 0; i <= t - 1; i++) {
    if (str[i] == 'I') ci++;
    if (str[i] == 'A') ca++;
    if (str[i] == 'F') cf++;
  }
  if (ci == 0) cout << ca;
  if (ci == 1) cout << ci;
  if (ci > 1) cout << "0";
  return 0;
}
