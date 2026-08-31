#include <bits/stdc++.h>
using namespace std;
char c[100000];
char k[1000000];
int pos = 1;
int neg = 0;
int main() {
  int j = 0;
  while (true) {
    char c;
    cin >> c;
    cin >> c;
    if (c == '=') break;
    if (c == '+') pos++;
    if (c == '-') neg++;
    k[j++] = c;
  }
  int n;
  cin >> n;
  int mini = (1 * pos - neg * n);
  int maxii = (pos * n - neg * 1);
  if (mini <= n && n <= maxii) {
    cout << "Possible" << endl;
  } else {
    cout << "Impossible" << endl;
    return 0;
  }
  int sum = 0;
  for (int i = 0; i < j; i++) {
    int sgn = 1;
    if (i > 0 && k[i - 1] == '-') sgn = -1;
    if (sgn == -1) neg--;
    if (sgn == 1) pos--;
    for (int x = 1; x <= n; x++) {
      if (sum + sgn * x + n * pos - neg >= n &&
          n >= sum + sgn * x + 1 * pos - n * neg) {
        sum += x * sgn;
        cout << x << " " << k[i] << " ";
        break;
      }
    }
  }
  cout << abs(n - sum) << " = " << n << endl;
  return 0;
}
