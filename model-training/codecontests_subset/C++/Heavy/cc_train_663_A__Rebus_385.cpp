#include <bits/stdc++.h>
using namespace std;
int n, x, y, nrm, nrp, nr;
int pls[500], mns[500];
char sir[1000000];
bool verif(int v1) {
  int v2 = v1 - nr;
  int lmin = y;
  int lmax = y * nr;
  if (v2 <= lmax && v2 >= lmin) {
    return 1;
  }
  return 0;
}
void afis(int v1) {
  int v2 = v1 - nr;
  int sign;
  for (int i = 1; i <= x; ++i) {
    pls[i] = v1 / x;
    if (i <= v1 % x) {
      ++pls[i];
    }
  }
  for (int i = 1; i <= y; ++i) {
    mns[i] = v2 / y;
    if (i <= v2 % y) {
      ++mns[i];
    }
  }
  if (sir[0] == '-') {
    sign = -1;
  } else {
    sign = 1;
  }
  for (int i = 0; i < n; ++i) {
    if (sir[i] == '?') {
      if (sign == 1) {
        cout << pls[++nrp] << " ";
      } else {
        cout << mns[++nrm] << " ";
      }
    } else {
      cout << sir[i];
    }
    if (sir[i] == '+') {
      cout << " ";
      sign = 1;
    }
    if (sir[i] == '-') {
      cout << " ";
      sign = -1;
    }
    if (sir[i] == '=') {
      cout << " ";
    }
  }
}
int main() {
  char ch;
  while (cin >> ch) {
    sir[n] = ch;
    ++n;
  }
  if (sir[0] == '-') {
    ++y;
  } else {
    ++x;
  }
  for (int i = 1; i < n; ++i) {
    if (sir[i] == '+') {
      ++x;
    }
    if (sir[i] == '-') {
      ++y;
    }
    while (sir[i] >= '0' && sir[i] <= '9' && i < n) {
      nr = nr * 10 + sir[i] - '0';
      ++i;
    }
  }
  int aux1 = x;
  int aux2 = x * nr;
  for (int i = aux1; i <= aux2; ++i) {
    if (verif(i)) {
      cout << "Possible\n";
      afis(i);
      return 0;
    }
  }
  cout << "Impossible\n";
  return 0;
}
