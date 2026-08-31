#include <bits/stdc++.h>
using namespace std;
double a, b, c, a1, a2, mini;
int n, i, j;
int main() {
  cin >> a >> b >> c;
  if (!a && !b) {
    if (!c)
      cout << "-1";
    else
      cout << "0";
    return 0;
  }
  if (!a) {
    a1 = (-c) / b;
    printf("1\n%lf", a1);
    return 0;
  }
  if ((b * b < (4 * a * c))) {
    cout << "0";
    return 0;
  }
  a1 = (-b + sqrt(b * b - (4 * c * a))) / (2 * a);
  a2 = (-b - sqrt(b * b - (4 * c * a))) / (2 * a);
  if (a1 == a2)
    printf("1\n%lf", a1);
  else {
    mini = a1 > a2 ? a2 : a1;
    a1 = a1 + a2 - mini;
    printf("2\n%lf\n%lf", mini, a1);
  }
  return 0;
}
