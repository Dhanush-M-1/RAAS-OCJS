#include <bits/stdc++.h>
using namespace std;
int main() {
  int TOTAL, SUM = 0, Z, MAX = 0, VOTE;
  cin >> TOTAL;
  for (Z = 0; Z < TOTAL; Z++) {
    cin >> VOTE;
    SUM = SUM + VOTE;
    if (VOTE > MAX) {
      MAX = VOTE;
    }
  }
  while (1) {
    if (MAX * TOTAL - SUM > SUM) {
      cout << MAX;
      break;
    }
    MAX++;
  }
  return 0;
}
