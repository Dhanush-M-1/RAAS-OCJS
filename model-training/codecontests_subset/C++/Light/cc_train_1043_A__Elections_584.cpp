#include <bits/stdc++.h>
using namespace std;
int main(void) {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long n;
  cin >> n;
  long long a[n];
  long long maxa = 0;
  long long suma = 0;
  for (__typeof(n) i = (0) - ((0) > (n)); i != (n) - ((0) > (n));
       i += 1 - 2 * ((0) > (n))) {
    cin >> a[i];
    if (a[i] > maxa) {
      maxa = a[i];
    }
    suma += a[i];
  }
  long long k = (2 * suma) / n;
  if (n * k <= (2 * suma)) {
    k++;
  }
  cout << max(maxa, k);
}
