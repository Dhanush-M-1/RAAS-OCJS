#include <bits/stdc++.h>
using namespace std;
int n, a[11][11];
int zh(int x) {
  long long sum = 0, i = 0;
  while (x) {
    sum = sum + ((x % n) * pow(10, i));
    i++;
    x /= n;
  }
  return sum;
}
int main() {
  cin >> n;
  for (int i = 1; i < n; i++) a[1][i] = a[i][1] = i;
  for (int i = 2; i < n; i++) {
    for (int j = 2; j < n; j++) {
      a[i][j] = zh(i * j);
    }
  }
  for (int i = 1; i < n; i++) {
    for (int j = 1; j < n; j++) cout << a[i][j] << " ";
    puts("");
  }
  return 0;
}
