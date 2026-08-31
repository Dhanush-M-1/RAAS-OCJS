#include <bits/stdc++.h>
using namespace std;
int main() {
  string cards;
  int n;
  cin >> n;
  cin >> cards;
  int e = n / 11;
  int _8 = 0;
  for (int i = 0; i < cards.size(); i++) {
    if (cards[i] == '8') _8++;
  }
  if (_8 > e)
    cout << e;
  else
    cout << _8;
}
