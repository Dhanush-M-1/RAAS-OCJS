#include <bits/stdc++.h>
using namespace std;
int func(long long int A1, long long int A2, long long int B1, long long int B2,
         long long int C1, long long int C2) {
  long long int divider = C1 * C1 + C2 * C2;
  long long int top1 = C1 * (B1 - A1) + C2 * (B2 - A2);
  long long int top2 = C1 * (B2 - A2) - C2 * (B1 - A1);
  if (divider == 0) {
    bool chk1 = B1 == A1 && B2 == A2, chk2 = B1 == -A2 && B2 == A1,
         chk3 = B1 == -A1 && B2 == -A2, chk4 = B1 == A2 && B2 == -A1;
    if (chk1 || chk2 || chk3 || chk4) {
      cout << "YES" << endl;
      return 1;
    }
    return 0;
  }
  if (top1 % divider == 0 && top2 % divider == 0) {
    cout << "YES" << endl;
    return 1;
  }
  return 0;
}
int main(void) {
  long long int A1, A2, B1, B2, C1, C2;
  cin >> A1 >> A2 >> B1 >> B2 >> C1 >> C2;
  if (func(A1, A2, B1, B2, C1, C2) || func(A1, A2, -B2, B1, C1, C2) ||
      func(A1, A2, -B1, -B2, C1, C2) || func(A1, A2, B2, -B1, C1, C2))
    return 0;
  cout << "NO" << endl;
  return 0;
}
