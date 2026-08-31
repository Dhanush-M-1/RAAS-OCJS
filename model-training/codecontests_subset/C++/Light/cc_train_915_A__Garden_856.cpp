#include <bits/stdc++.h>
using namespace std;
int i, j, n, m, mas[105], ab[105], rez;
int main() {
  cin >> n >> m;
  i = 0;
  while (i < n) {
    cin >> mas[i];
    if (m % mas[i] == 0) {
      ab[i] = m / mas[i];
    }
    i = i + 1;
  }
  i = 0;
  rez = 1000000000;
  while (i < n) {
    if (ab[i] > 0) {
      rez = min(rez, ab[i]);
    }
    i = i + 1;
  }
  cout << rez;
  return (0);
}
