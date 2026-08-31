#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  int phone_numbers = 0;
  int eights = 0;
  cin >> n;
  string cards;
  cin >> cards;
  for (int i = 0; i < n; i++) {
    if (cards[i] == '8') eights++;
  }
  for (int i = 0; i < eights; i++) {
    if (n - 11 >= 0) phone_numbers++;
    n = n - 11;
  }
  cout << phone_numbers;
  return 0;
}
