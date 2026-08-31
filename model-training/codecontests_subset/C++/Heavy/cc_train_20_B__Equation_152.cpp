#include <bits/stdc++.h>
using namespace std;
int main() {
  long long a, b, c;
  cin >> a >> b >> c;
  if (a == 0 && b != 0) {
    cout << 1 << endl;
    cout << fixed << setprecision(5) << -1.0 * c / b << endl;
  } else if (a != 0 && b == 0) {
    double resp = c * 1.0 / a;
    if (resp < 0) {
      cout << 2 << endl;
      cout << fixed << setprecision(5) << -1 * sqrt(resp) << endl;
      cout << fixed << setprecision(5) << sqrt(resp) << endl;
    } else if (resp > 0) {
      cout << 0 << endl;
    } else {
      cout << 1 << endl;
      cout << fixed << setprecision(5) << 0 << endl;
    }
  } else if (a == 0 && b == 0) {
    if (c == 0)
      cout << -1 << endl;
    else
      cout << 0 << endl;
  } else {
    if (a != 0 && b != 0) {
      long long aux = b * b - 4 * a * c;
      if (aux < 0) {
        cout << 0 << endl;
      } else {
        if (aux == 0) {
          cout << 1 << endl;
          double resp23 = (-b) / (2 * a);
          cout << fixed << setprecision(5) << resp23 << endl;
        } else {
          double tri = sqrt(aux);
          double raiz1 = (-b - tri) / (2 * a);
          double raiz2 = (-b + tri) / (2 * a);
          cout << 2 << endl;
          if (raiz2 < raiz1) swap(raiz1, raiz2);
          cout << fixed << setprecision(5) << raiz1 << endl;
          cout << fixed << setprecision(5) << raiz2 << endl;
        }
      }
    }
  }
  return 0;
}
