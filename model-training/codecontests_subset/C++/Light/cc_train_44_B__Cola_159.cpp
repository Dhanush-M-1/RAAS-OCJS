#include <bits/stdc++.h>
using namespace std;
int mas[10001];
int main() {
  int n, a, b, c, kol = 0;
  cin >> n >> a >> b >> c;
  for (int i = 0; i <= a; i += 2)
    for (int j = 0; j <= b; j++) {
      int p = i / 2;
      mas[p + j]++;
    }
  for (int i = 0; i <= c; i++)
    if (2 * i <= n)
      kol += mas[n - 2 * i];
    else
      i = c + 1;
  cout << kol;
  return 0;
}
