#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<int> v(n);
  int suma = 0;
  for (int i = 0; i < n; i++) {
    cin >> v[i];
    suma += v[i];
  }
  if (suma % 200 == 0 and (suma != 200 * n or n % 2 == 0)) {
    cout << "YES" << endl;
  } else {
    cout << "NO" << endl;
  }
  return 0;
}
