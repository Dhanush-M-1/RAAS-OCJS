#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, cont = 0;
  cin >> n;
  char a[n];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    if (a[i] == 'I') cont++;
  }
  if (cont == 1) cout << "1";
  if (cont > 1) cout << "0";
  if (cont == 0) {
    for (int i = 0; i < n; i++) {
      if (a[i] == 'A') cont++;
    }
    cout << cont;
  }
  return 0;
}
