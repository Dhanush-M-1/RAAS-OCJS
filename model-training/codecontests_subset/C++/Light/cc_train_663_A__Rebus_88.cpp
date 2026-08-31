#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  getline(cin, s);
  int l = 0, k = 0;
  string a;
  bool atual = true;
  istringstream buffer(s);
  while (buffer >> a && a != "=") {
    if (a == "-") {
      atual = false;
      continue;
    }
    if (a == "+") {
      atual = true;
      continue;
    }
    if (atual)
      k++;
    else
      l++;
  }
  int n;
  buffer >> n;
  int saldo = -n;
  int pos[k], neg[l];
  for (int i = 0; i < k; i++) pos[i] = 1;
  for (int i = 0; i < l; i++) neg[i] = 1;
  saldo += k - l;
  int i = 0, j = 0;
  if (k * n < l + n || k > (l + 1) * n) {
    printf("Impossible\n");
    return 0;
  }
  printf("Possible\n");
  while (saldo != 0) {
    if (saldo < 0) {
      if (-saldo >= n)
        pos[i] += n - 1, i++, saldo += n - 1;
      else
        pos[i] += -saldo, i++, saldo = 0;
    } else {
      if (saldo >= n)
        neg[j] += n - 1, j++, saldo -= n - 1;
      else
        neg[j] += saldo, j++, saldo = 0;
    }
  }
  istringstream buf(s);
  atual = true;
  while (buf >> a && a != "=") {
    if (a == "-") {
      cout << a << " ";
      atual = false;
      continue;
    }
    if (a == "+") {
      cout << a << " ";
      atual = true;
      continue;
    }
    if (atual) {
      cout << pos[--k] << " ";
    } else {
      cout << neg[--l] << " ";
    }
  }
  printf("= %d\n", n);
}
