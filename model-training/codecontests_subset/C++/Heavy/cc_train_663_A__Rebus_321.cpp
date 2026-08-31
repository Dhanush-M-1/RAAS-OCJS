#include <bits/stdc++.h>
using namespace std;
string x;
long long int suma, V[200], neg, poz, suma1, nr1, nr2, k, i;
int main() {
  cin >> x;
  poz = 1;
  while (cin >> x) {
    if (x == "+") {
      V[neg + poz] = 1;
      poz++;
      cin >> x;
    } else if (x == "-") {
      V[neg + poz] = 0;
      neg++;
      cin >> x;
    } else if (x == "=") {
      cin >> suma;
    }
  }
  if (suma + neg > suma * poz || poz > suma + neg * suma)
    cout << "Impossible";
  else {
    cout << "Possible \n";
    k = 1;
    int var = neg + poz;
    while (suma + k * neg < poz) k++;
    suma1 = suma + k * neg;
    nr1 = suma1 / poz;
    nr2 = suma1 - suma1 / poz * poz;
    cout << nr1;
    for (i = 1; i < var; i++) {
      if (V[i] == 0)
        cout << " - " << k;
      else if (nr2 > 0) {
        cout << " + " << nr1 + 1;
        nr2--;
      } else
        cout << " + " << nr1;
    }
    cout << " = " << suma;
  }
}
