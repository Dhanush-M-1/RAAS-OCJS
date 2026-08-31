#include <bits/stdc++.h>
using namespace std;
int a[10][10] = {};
void output(int base, int num) {
  int i = 1, j;
  while (i <= num) i *= base;
  i /= base;
  while (i != 0) {
    j = num / i;
    cout << j;
    num %= i;
    i /= base;
  }
  cout << ' ';
  return;
}
int main() {
  int k;
  cin >> k;
  for (int i = 1; i < k; i++)
    for (int j = 1; j < k; j++) a[i][j] = i * j;
  for (int i = 1; i < k; i++) {
    for (int j = 1; j < k; j++) output(k, a[i][j]);
    cout << endl;
  }
  return 0;
}
