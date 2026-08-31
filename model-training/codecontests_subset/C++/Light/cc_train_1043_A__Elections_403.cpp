#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int a[n + 1];
  int suma = 0;
  int maxi = 0;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    suma += a[i];
    maxi = max(maxi, a[i]);
  }
  int sumb = 0;
  for (int i = 1; i <= n; i++) {
    sumb += maxi - a[i];
  }
  while (sumb <= suma) {
    sumb += n;
    maxi++;
  }
  cout << maxi << endl;
}
