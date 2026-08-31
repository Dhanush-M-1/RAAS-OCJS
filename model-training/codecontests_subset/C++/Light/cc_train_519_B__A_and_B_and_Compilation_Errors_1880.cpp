#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n;
  cin >> n;
  long long suma = 0, sumb = 0, sumc = 0, x;
  for (long long i = 0; i < n; i++) cin >> x, suma += x;
  for (long long i = 0; i < n - 1; i++) cin >> x, sumb += x;
  for (long long i = 0; i < n - 2; i++) cin >> x, sumc += x;
  cout << suma - sumb << endl << sumb - sumc;
  return 0;
}
