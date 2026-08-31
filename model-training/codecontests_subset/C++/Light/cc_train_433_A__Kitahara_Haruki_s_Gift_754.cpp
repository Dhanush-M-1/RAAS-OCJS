#include <bits/stdc++.h>
using namespace std;
int main() {
  int num, suma1 = 0, suma2 = 0, cont1 = 0, cont2 = 0, aux;
  cin >> num;
  for (int i = 0; i < num; i++) {
    cin >> aux;
    if (aux == 100) {
      suma1 += 100;
      cont1++;
    } else {
      suma2 += 200;
      cont2++;
    }
  }
  if (num == 1) {
    cout << "NO";
    return 0;
  }
  if (cont1 % 2 != 0) {
    cout << "NO";
    return 0;
  }
  if (cont2 == 0) {
    cout << "YES";
    return 0;
  }
  if (cont2 % 2 != 0 && cont1 != 0) {
    cout << "YES";
    return 0;
  } else if (cont2 % 2 != 0 && cont1 == 0) {
    cout << "NO";
    return 0;
  }
  if (cont2 % 2 == 0) {
    cout << "YES";
    return 0;
  }
}
