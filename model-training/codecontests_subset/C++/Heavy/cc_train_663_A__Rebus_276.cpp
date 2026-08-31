#include <bits/stdc++.h>
using namespace std;
int main() {
  char next;
  long long int neg = 0, pos = 0;
  cin >> next;
  bool estado = false;
  string orden = "";
  while (next != '=') {
    if (next == ' ') {
      cin >> next;
    }
    if (next == '-') {
      estado = true;
      cin >> next;
    }
    if (next == '+') {
      estado = false;
      cin >> next;
    }
    if (next == '?') {
      if (estado) {
        orden += '-';
        neg++;
      } else {
        orden += '+';
        pos++;
      }
    }
    cin >> next;
  }
  long long int num;
  cin >> num;
  long long int coefs[neg + pos];
  if ((neg > ((pos - 1) * num)) || ((pos - neg * num) > num)) {
    cout << "Impossible";
    return 0;
  }
  long long int valpos = 0, valneg = 0;
  cout << "Possible" << endl;
  if (neg == 0) {
    long long int cv = trunc(num / pos);
    long long int sum = 0;
    for (int i = 0; i < pos; i++) {
      coefs[i] = cv;
    }
    sum = cv * pos - num;
    if (sum != 0) {
      for (int i = 0; i < pos; i++) {
        coefs[i]++;
        sum++;
        if (sum == 0) break;
      }
    }
    cout << coefs[0];
    for (int i = 1; i < pos; i++) {
      cout << " + " << coefs[i];
    }
    cout << " = " << num;
    return 0;
  }
  if (pos - 1 > neg) {
    valpos = 1;
    valneg = trunc((pos - 1) / neg);
  } else {
    valneg = 1;
    valpos = trunc(neg / (pos - 1));
  }
  int ref;
  for (int i = 0; i < orden.size(); i++) {
    if (orden[i] == '-') {
      coefs[i] = -valneg;
    } else
      coefs[i] = valpos;
  }
  coefs[0] = num;
  long long int suma = 0;
  for (int i = 0; i < neg + pos; i++) {
    suma += coefs[i];
  }
  suma -= num;
  if (suma < 0) {
    for (int i = 1; i < neg + pos; i++) {
      if (coefs[i] > 0 && (abs(coefs[i]) < num)) {
        coefs[i]++;
        suma++;
      }
      if (suma == 0) break;
    }
  }
  if (suma > 0) {
    for (int i = 1; i < neg + pos; i++) {
      if (coefs[i] < 0 && (abs(coefs[i]) < num)) {
        coefs[i]--;
        suma--;
      }
      if (suma == 0) break;
    }
  }
  for (int i = 1; i < neg + pos; i++) {
    if (abs(coefs[i]) > num) {
      if (coefs[i] < 0) {
        suma += -num - coefs[i];
        coefs[i] = -num;
      } else {
        suma += num - coefs[i];
        coefs[i] = num;
      }
    }
  }
  if (suma > 0) {
    coefs[0] -= suma;
    suma -= suma;
  }
  if (suma < 0) {
    coefs[0] += suma;
    suma -= suma;
  }
  cout << coefs[0];
  for (int i = 1; i < pos + neg; i++) {
    if (coefs[i] < 0)
      cout << " - " << abs(coefs[i]);
    else
      cout << " + " << coefs[i];
  }
  cout << " = " << suma + num;
  return 0;
}
