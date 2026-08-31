#include <bits/stdc++.h>
using namespace std;
int main() {
  int total = 0;
  for (int i = 0; i < 5; i++) {
    int aux;
    cin >> aux;
    total += aux;
  }
  if (total == 0) {
    cout << "-1" << endl;
    return 0;
  }
  if (total % 5 == 0)
    cout << total / 5 << endl;
  else
    cout << "-1" << endl;
}
