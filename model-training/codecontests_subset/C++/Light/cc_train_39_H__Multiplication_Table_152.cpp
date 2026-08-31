#include <bits/stdc++.h>
using namespace std;
int mabna(int a, int x) {
  string s;
  while (a >= x) {
    s += (char)(a % x) + '0';
    a /= x;
  }
  if (a != 0) {
    s += (char)a + '0';
  }
  int numb;
  reverse(s.begin(), s.end());
  istringstream(s) >> numb;
  return numb;
}
int main() {
  int n;
  cin >> n;
  int a[10][10];
  for (int i = 0; i < 9; i++) {
    for (int j = 0; j < 9; j++) {
      a[i][j] = (i + 1) * (j + 1);
    }
  }
  for (int i = 0; i < n - 1; i++) {
    for (int j = 0; j < n - 1; j++) {
      cout << mabna(a[i][j], n) << " ";
    }
    cout << endl;
  }
}
