#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c, a;
  vector<int> lista;
  cin >> n >> c;
  for (int i = 0; i < n; i++) {
    cin >> a;
    lista.push_back(a);
  }
  int res = 0;
  for (int i = 0; i < n - 1; i++) {
    int aux = lista[i] - c - lista[i + 1];
    if (aux > res) {
      res = aux;
    }
  }
  cout << res;
  return 0;
}
