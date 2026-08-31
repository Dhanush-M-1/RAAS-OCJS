#include <bits/stdc++.h>
using namespace std;
int main() {
  long p, ka = 0, ki = 0;
  cin >> p;
  char str;
  for (long i = 0; i < p; i++) {
    cin >> str;
    if (str == 'A') ka++;
    if (str == 'I') ki++;
  }
  if (ki > 1) cout << 0;
  if (ki == 1) cout << 1;
  if (ki == 0) cout << ka;
  return 0;
}
