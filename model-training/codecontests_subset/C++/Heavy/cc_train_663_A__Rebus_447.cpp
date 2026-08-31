#include <bits/stdc++.h>
using namespace std;
int n, a, b, x, y, i, j, m[105];
char t, c[105];
int main() {
  c[0] = '+';
  j = 1;
  while (2 > 1) {
    cin >> t;
    if (t == '=') {
      break;
    }
    if (t != '?') {
      c[j] = t;
      j++;
    }
  }
  cin >> n;
  while (i < j) {
    m[i] = 1;
    if (c[i] == '+') {
      x += m[i];
    } else {
      x -= m[i];
    }
    i++;
  }
  i = 0;
  while (x > n) {
    while (c[i] != '-') {
      i++;
    }
    while (x > n && m[i] < n) {
      m[i]++;
      x--;
    }
    i++;
    if (i > 101) {
      cout << "Impossible";
      return 0;
    }
  }
  i = 0;
  while (x < n) {
    while (c[i] != '+') {
      i++;
    }
    while (x < n && m[i] < n) {
      m[i]++;
      x++;
    }
    i++;
    if (i > 101) {
      cout << "Impossible";
      return 0;
    }
  }
  i = 0;
  cout << "Possible" << endl;
  while (i < j) {
    cout << m[i] << " ";
    if (i != j - 1) {
      cout << c[i + 1] << " ";
    }
    i++;
  }
  cout << "= " << n;
}
