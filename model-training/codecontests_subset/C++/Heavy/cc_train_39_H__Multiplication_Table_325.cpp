#include <bits/stdc++.h>
using namespace std;
int a[20][20], b[20];
int n;
int jinzhi(int m, int k) {
  memset(b, 0, sizeof(b));
  int cnt = 0, sum = 0;
  while (m > 0) {
    cnt++;
    b[cnt] = m % k;
    m /= k;
  }
  for (int i = cnt; i >= 1; i--) {
    sum *= 10;
    sum += b[i];
  }
  return sum;
}
int main() {
  cin >> n;
  for (int i = 1; i < n; i++) {
    a[i][1] = i;
    a[1][i] = i;
  }
  for (int i = 2; i < n; i++) {
    for (int j = 2; j < n; j++) {
      a[i][j] = a[i][1] * a[1][j];
    }
  }
  for (int i = 1; i < n; i++) {
    for (int j = 1; j < n; j++) {
      a[i][j] = jinzhi(a[i][j], n);
    }
  }
  for (int i = 1; i < n; i++) {
    for (int j = 1; j < n; j++) {
      cout << a[i][j] << " ";
    }
    cout << endl;
  }
  return 0;
}
