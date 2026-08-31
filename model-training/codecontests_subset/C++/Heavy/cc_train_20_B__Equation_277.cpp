#include <bits/stdc++.h>
using namespace std;
int main() {
  long long A, B, C;
  cin >> A >> B >> C;
  if (!A) {
    if (!B) {
      if (!C)
        cout << -1;
      else
        cout << 0;
      return 0;
    }
    cout << 1 << '\n';
    cout << fixed << setprecision(10) << (long double)-C / B;
    return 0;
  }
  long long D = B * B - 4 * A * C;
  if (D < 0) {
    cout << 0;
    return 0;
  }
  if (!D) {
    cout << 1 << '\n';
    cout << fixed << setprecision(10) << (long double)-B / (2 * A);
    return 0;
  }
  cout << 2 << '\n';
  if (A < 0) {
    cout << fixed << setprecision(10) << (long double)(-B + sqrt(D)) / (2 * A)
         << '\n';
    cout << fixed << setprecision(10) << (long double)(-B - sqrt(D)) / (2 * A);
  } else {
    cout << fixed << setprecision(10) << (long double)(-B - sqrt(D)) / (2 * A)
         << '\n';
    cout << fixed << setprecision(10) << (long double)(-B + sqrt(D)) / (2 * A);
  }
  return 0;
}
