#include <bits/stdc++.h>
using namespace std;
int n, i, j;
int x, y, r;
int F1[50], F2[50];
int printN(int a) {
  if (a < 0) {
    cout << "(0-";
    printN(-a);
    cout << ")";
  } else if (a <= 50)
    cout << a;
  else {
    cout << "(50+";
    printN(a - 50);
    cout << ")";
  }
  return 0;
}
int printF(int *F, int i) {
  int m = F[i], a = F[i - 1], b = F[i + 1];
  cout << "((";
  printN(m);
  cout << "+(";
  printN((b - a) / 2);
  cout << "*((t-" << i << ")-abs((t-" << i << ")))))+abs(";
  for (int j = i; j < n; j++) F[j] -= m;
  if (i < n - 2)
    printF(F, i + 1);
  else {
    cout << "(";
    printN(b - m);
    cout << "*(t-" << i << "))";
  }
  cout << "))";
  return 0;
}
int main() {
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> x >> y >> r;
    F1[i] = 2 * (x / 2);
    F2[i] = 2 * (y / 2);
  }
  if (n == 1)
    cout << F1[0] << endl << F2[0];
  else if (n == 2) {
    cout << "(" << F1[0];
    if (F1[1] >= F1[0])
      cout << "+(" << F1[1] - F1[0];
    else
      cout << "-(" << F1[0] - F1[1];
    cout << "*t))" << endl;
    cout << "(" << F2[0];
    if (F2[1] > F2[0])
      cout << "+(" << F2[1] - F2[0];
    else
      cout << "-(" << F2[0] - F2[1];
    cout << "*t))";
  } else {
    for (i = 0; i < n; i++) F1[i] += i * 50, F2[i] += i * 50;
    cout << "(";
    printF(F1, 1);
    cout << "-(50*t))" << endl;
    cout << "(";
    printF(F2, 1);
    cout << "-(50*t))";
  }
  return 0;
}
