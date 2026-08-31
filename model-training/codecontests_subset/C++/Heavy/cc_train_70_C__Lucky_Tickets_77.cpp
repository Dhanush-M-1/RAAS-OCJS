#include <bits/stdc++.h>
using namespace std;
const int MAX_N = 100 * 1000;
const long long INF = (1LL << 30) * (1LL << 30);
map<double, long long> M1;
map<double, long long> M2;
long long Mx, My;
long long W;
long long rev(long long x) {
  long long ret = 0;
  while (x) {
    ret *= 10;
    ret += x % 10;
    x /= 10;
  }
  return ret;
}
int main() {
  cin >> Mx >> My >> W;
  for (long long i = 1; i <= Mx; i++) M1[(double)i / (double)rev(i)]++;
  long long Ansa = -1;
  long long Ansb = -1;
  long long X = Mx;
  long long Y = 0;
  long long NOW = 0;
  while (X >= 1 && Y <= My) {
    if (NOW < W) {
      Y++;
      double TEMP = (double)rev(Y) / (double)Y;
      M2[TEMP]++;
      NOW += M1[TEMP];
    } else {
      if (Ansa == -1 || Ansa * Ansb > X * Y) Ansa = X, Ansb = Y;
      double TEMP = (double)X / (double)rev(X);
      NOW -= M2[TEMP];
      M1[TEMP]--;
      X--;
    }
  }
  if (Ansa == -1)
    cout << -1 << endl;
  else
    cout << Ansa << " " << Ansb << endl;
}
