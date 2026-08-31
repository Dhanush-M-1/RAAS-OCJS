#include <bits/stdc++.h>
using namespace std;
long long k, b[100009], x, n, i, l, a[100009], j;
int main() {
  cin >> n;
  for (i = 2; i * i <= n; i++)
    if (n % i == 0) {
      a[l] = i;
      for (j = 0; n % i == 0; j++) n /= i;
      b[l++] = j;
      k += j;
    }
  if (n > 1) {
    a[l] = n;
    b[l++] = 1;
    k++;
  }
  if (k == 1) {
    cout << "1\n0";
    return 0;
  }
  if (k == 2) {
    cout << "2";
    return 0;
  }
  cout << "1\n";
  x = a[0];
  b[0]--;
  if (b[0] > 0)
    x *= a[0];
  else
    x *= a[1];
  cout << x;
}
