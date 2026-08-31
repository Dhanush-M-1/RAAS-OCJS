#include <bits/stdc++.h>
using namespace std;
int ar[3];
int main() {
  int a, b;
  cin >> a;
  for (int i = 0; i < 3; i++) {
    for (int j = 0; j < a - i; j++) {
      cin >> b;
      ar[i] += b;
    }
  }
  cout << ar[0] - ar[1] << endl << ar[1] - ar[2];
  cout << endl;
  return 0;
}
