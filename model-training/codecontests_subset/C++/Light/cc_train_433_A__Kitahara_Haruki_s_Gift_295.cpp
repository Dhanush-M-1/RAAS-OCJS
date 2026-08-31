#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int a[n], sum = 0, cunt = 0, loda = 0;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    sum += a[i];
    if (a[i] == 100)
      cunt++;
    else
      loda++;
  }
  if ((cunt > 0 && cunt % 2 == 0) || sum % 400 == 0) {
    cout << "YES\n";
  } else
    cout << "NO\n";
}
