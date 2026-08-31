#include <bits/stdc++.h>
using namespace std;
int main() {
  int n = 0;
  cin >> n;
  int liczba_osemek = 0;
  string s;
  cin >> s;
  if (s.size() < 8) {
    cout << "0";
    return 0;
  } else
    for (int i = 0; i < n; i++) {
      if (s[i] == '8') liczba_osemek++;
    }
  if (liczba_osemek == 0) {
    cout << "0";
    return 0;
  }
  int liczba_jedenastek = n / 11;
  if (liczba_osemek <= liczba_jedenastek) {
    cout << liczba_osemek;
    return 0;
  }
  int a = 0;
  if (liczba_osemek > liczba_jedenastek) {
    a = liczba_jedenastek % liczba_osemek;
    cout << a;
    return 0;
  } else {
    cout << liczba_jedenastek;
    return 0;
  }
}
