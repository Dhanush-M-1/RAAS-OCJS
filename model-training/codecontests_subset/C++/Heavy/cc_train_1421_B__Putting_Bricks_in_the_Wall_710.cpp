#include <bits/stdc++.h>
using namespace std;
const int N = 210;
char a[N][N];
int n;
void pp(void) {
  if (a[1][2] == '1')
    cout << 1 << endl << ' ' << 1 << ' ' << 2 << endl;
  else
    cout << 1 << endl << ' ' << 2 << ' ' << 1 << endl;
}
void pp1(void) {
  if (a[n - 1][n] == '0')
    cout << 1 << endl << ' ' << n - 1 << ' ' << n << endl;
  else
    cout << 1 << endl << ' ' << n << ' ' << n - 1 << endl;
}
void pp2(void) {
  if (a[1][2] == '0')
    cout << 1 << endl << ' ' << 1 << ' ' << 2 << endl;
  else
    cout << 1 << endl << ' ' << 2 << ' ' << 1 << endl;
}
void pp3(void) {
  if (a[n - 1][n] == '1')
    cout << 1 << endl << ' ' << n - 1 << ' ' << n << endl;
  else
    cout << 1 << endl << ' ' << n << ' ' << n - 1 << endl;
}
void pp4(void) {
  if (a[1][2] == '0') {
    cout << 2 << endl << ' ' << 1 << ' ' << 2 << endl;
    if (a[n - 1][n] == '1')
      cout << n - 1 << ' ' << n << endl;
    else
      cout << n << ' ' << n - 1 << endl;
  } else {
    cout << 2 << endl << ' ' << 2 << ' ' << 1 << endl;
    if (a[n - 1][n] == '1')
      cout << n - 1 << ' ' << n << endl;
    else
      cout << n << ' ' << n - 1 << endl;
  }
}
int main(void) {
  int t;
  cin >> t;
  while (t--) {
    cin >> n;
    int s1 = 0, s0 = 0, f1 = 0, f0 = 0;
    for (int i = 1; i <= n; i++)
      for (int j = 1; j <= n; j++) cin >> a[i][j];
    if (a[2][1] == '0')
      s0++;
    else
      s1++;
    if (a[1][2] == '1')
      s1++;
    else
      s0++;
    if (a[n][n - 1] == '0')
      f0++;
    else
      f1++;
    if (a[n - 1][n] == '1')
      f1++;
    else
      f0++;
    if ((f1 == 2 && s1 == 2) || (s1 == 0 && f1 == 0))
      cout << 2 << endl << 1 << ' ' << 2 << endl << 2 << ' ' << 1 << endl;
    else if (s1 == 1 && f1 == 2)
      pp();
    else if (s1 == 0 && f1 == 1)
      pp1();
    else if (s1 == 0 && f1 == 2)
      cout << 0 << endl;
    else if (s1 == 2 && f1 == 0)
      cout << 0 << endl;
    else if (s1 == 1 && f1 == 0)
      pp2();
    else if (s1 == 2 && f1 == 1)
      pp3();
    else if (s1 == 1 && f1 == 1) {
      pp4();
    }
  }
}
