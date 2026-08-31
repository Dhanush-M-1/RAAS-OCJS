#include <bits/stdc++.h>
const double eps = 1e-8;
const double pi = 3.1415926535897932;
using namespace std;
ifstream in("input.txt", ifstream::in);
ofstream out("output.txt", ofstream::out);
int main() {
  double ans[2];
  long long A, B, C;
  cin >> A >> B >> C;
  if (A == 0) {
    if (B == 0) {
      if (C == 0)
        cout << -1;
      else
        cout << 0;
    } else {
      if (C == 0)
        cout << "1\n0.000000";
      else {
        cout << 1 << endl;
        cout << fixed << setprecision(6) << (double)-C / B;
      }
    }
  } else if (B == 0) {
    if (C == 0)
      cout << "1\n0.000000";
    else {
      if (C < 0) {
        cout << 2 << endl;
        ans[0] = sqrt((double)C / A);
        ans[1] = -ans[0];
        if (ans[0] > ans[1]) swap(ans[0], ans[1]);
        cout << fixed << setprecision(6) << ans[0] << endl << ans[1];
      } else
        cout << 0;
    }
  } else {
    double D = B * B - 4 * A * C;
    if (D > 0) {
      D = sqrt(D);
      cout << 2 << endl;
      ans[0] = (-B + D) / (2 * A);
      ans[1] = (-B - D) / (2 * A);
      if (ans[0] > ans[1]) swap(ans[0], ans[1]);
      cout << fixed << setprecision(6) << ans[0] << endl << ans[1];
    } else if (D == 0) {
      cout << 1 << endl;
      cout << fixed << setprecision(6) << (double)-B / 2 / A;
    } else
      cout << 0;
  }
  return 0;
}
