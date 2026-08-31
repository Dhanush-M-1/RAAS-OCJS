#include <bits/stdc++.h>
using namespace std;
int a, b[1111], c[1111], d;
int cnt;
int main() {
  cin >> a;
  for (int i = 1; i <= a; i++) {
    cin >> b[i] >> c[i];
  }
  for (int i = 1; i <= a; i++) {
    for (int j = 1; j <= a; j++) {
      if (i != j) {
        if (b[i] == c[j]) {
          cnt++;
        }
        if (c[i] == b[j]) {
          cnt++;
        }
      }
    }
  }
  cout << cnt / 2;
  return 0;
}
