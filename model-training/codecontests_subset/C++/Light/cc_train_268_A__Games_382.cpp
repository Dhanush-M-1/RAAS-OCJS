#include <bits/stdc++.h>
using namespace std;
int main() {
  int nom, counter = 0;
  cin >> nom;
  int uniform[nom][2];
  for (int i = 0; i < nom; i++) {
    for (int j = 0; j < 2; j++) {
      cin >> uniform[i][j];
    }
  }
  for (int i = 0; i < nom; i++) {
    for (int j = i + 1; j < nom; j++) {
      if (uniform[i][0] == uniform[j][1]) counter++;
      if (uniform[i][1] == uniform[j][0]) counter++;
    }
  }
  cout << counter;
  return 0;
}
