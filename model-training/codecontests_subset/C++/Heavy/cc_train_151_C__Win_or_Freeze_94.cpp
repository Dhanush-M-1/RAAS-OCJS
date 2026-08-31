#include <bits/stdc++.h>
using namespace std;
const long long INF = (long long)1e17 + 99999999;
const long long Mod = (long long)1e9 + 7;
const long long MaXN = (long long)1e18;
const int N = (int)1e6 + 7;
const int MaXI = (int)1e9;
const int Mass = (int)2e5;
long long prime(long long x) {
  long long Pr = 2;
  while (Pr * Pr <= x) {
    if (x % Pr == 0) return Pr;
    Pr++;
  }
  return 0;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(NULL);
  cout.tie(NULL);
  long long n;
  cin >> n;
  if (n == 1) {
    cout << 1 << "\n" << 0;
    return 0;
  } else {
    long long Res = prime(n);
    if (Res == 0) {
      cout << 1 << "\n" << 0;
      return 0;
    }
    long long Cur = prime(n / Res);
    if (Cur == 0) {
      cout << 2;
    } else {
      cout << 1 << "\n" << Res * Cur;
    }
  }
  return 0;
}
