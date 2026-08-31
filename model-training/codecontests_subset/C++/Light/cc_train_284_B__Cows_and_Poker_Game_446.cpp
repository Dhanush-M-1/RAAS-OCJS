#include <bits/stdc++.h>
using namespace std;
int main() {
  long int n;
  long int qtde_i, qtde_a;
  char ch;
  cin >> n;
  qtde_i = 0;
  qtde_a = 0;
  for (long int i = 0; i < n; i++) {
    cin >> ch;
    if (ch == 'I') {
      qtde_i += 1;
    } else if (ch == 'A') {
      qtde_a += 1;
    }
  }
  if (0) {
    cout << "MAIN : char lidos =" << n << endl;
    cout << "QTDE_I = " << qtde_i << endl;
    cout << "QTDE_A = " << qtde_a << endl;
  }
  if (qtde_i > 0) {
    if (qtde_i > 1) {
      cout << 0 << endl;
    } else {
      cout << 1 << endl;
    }
  } else {
    cout << qtde_a << endl;
  }
  return 0;
}
