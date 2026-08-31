#include <bits/stdc++.h>
using namespace std;
int a, b, c, s[11000001], i;
int main() {
  cin >> a;
  for (i = 1; i <= a; i++) {
    cin >> s[i];
    if (s[i] == 100) {
      b++;
    } else {
      c += 2;
    }
  }
  if (a == 1) {
    cout << "NO";
    return 0;
  }
  if (b == 0 && a % 2 == 1) {
    cout << "NO";
    return 0;
  }
  if (b == 0 && a % 2 == 0) {
    cout << "YES";
    return 0;
  }
  if (c == 0 && a % 2 == 0) {
    cout << "YES";
    return 0;
  }
  if (c == 0 && a % 2 == 1) {
    cout << "NO";
    return 0;
  }
  if (b % 2 == 1) {
    cout << "NO";
    return 0;
  }
  if (b % 2 == 0) {
    cout << "YES";
    return 0;
  }
  if (abs(b - c) % 2 == 0) {
    cout << "YES";
  } else {
    cout << "NO";
  }
  return 0;
}
