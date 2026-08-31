#include <bits/stdc++.h>
using namespace std;
int main() {
  int k = 0, n, pos = 1, neg = 0;
  char s[100];
  char c;
  while (1) {
    scanf(" %c", &c);
    scanf(" %c", &c);
    if (c == '=') break;
    if (c == '+') pos++;
    if (c == '-') neg++;
    s[k++] = c;
  }
  cin >> n;
  if (pos - n * neg > n || n * pos - neg < n) {
    puts("Impossible");
    return 0;
  }
  puts("Possible");
  int S = 0;
  for (int i = 0; i < k; i++) {
    int sgn = 1;
    if (i && s[i - 1] == '-') sgn = -1;
    if (sgn == 1)
      pos--;
    else
      neg--;
    for (int x = 1; x <= n; x++) {
      if (S + x * sgn + pos - n * neg <= n &&
          S + x * sgn + n * pos - neg >= n) {
        cout << x << " " << s[i] << " ";
        S += x * sgn;
        break;
      }
    }
  }
  cout << abs(n - S) << " = " << n << endl;
}
