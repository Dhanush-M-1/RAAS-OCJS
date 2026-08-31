#include <bits/stdc++.h>
using namespace std;
const int limite = 1000001;
int a[limite];
int posicion[limite];
int main() {
  ios_base::sync_with_stdio(false);
  int na, nb;
  cin >> na >> nb;
  for (int i = 1; i <= na; i++) cin >> a[i];
  for (int i = 1; i <= nb; i++) {
    int b;
    cin >> b;
    posicion[b] = i;
  }
  int ii = 1;
  int len = 1;
  int maximo = 0;
  for (int i = 1; i <= na; i++) {
    len = max(len - 1, 1);
    if (posicion[a[i]] == 0) {
      ii = i + 1;
      len = 1;
      continue;
    }
    for (;;) {
      int nextii = (ii + 1);
      if (nextii > na) nextii = 1;
      if (nextii == i) break;
      if (posicion[a[nextii]] == 0) break;
      if (i == ii) {
        ii = nextii;
        len = 2;
      } else {
        int pi = posicion[a[i]];
        int pii = posicion[a[ii]];
        int pnextii = posicion[a[nextii]];
        if (pi < pii and pi < pnextii and pnextii < pii) break;
        if (pii < pi and pi < pnextii) break;
        if (pii < pi and pnextii < pii) break;
        ii = nextii;
        len++;
      }
    }
    maximo = max(maximo, len);
  }
  cout << maximo << endl;
}
