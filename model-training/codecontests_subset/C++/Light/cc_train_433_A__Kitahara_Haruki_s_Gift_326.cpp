#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, aux, total, target, total_100 = 0, total_200 = 0;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> aux;
    if (aux == 100) {
      total_100++;
    } else {
      total_200++;
    }
  }
  total = total_100 * 100 + total_200 * 200;
  target = total / 2;
  aux = min(total_200, target / 200) * 200;
  target -= aux;
  aux = min(total_100, target / 100) * 100;
  target -= aux;
  if (!target) {
    cout << "YES" << endl;
  } else {
    cout << "NO" << endl;
  }
  return 0;
}
