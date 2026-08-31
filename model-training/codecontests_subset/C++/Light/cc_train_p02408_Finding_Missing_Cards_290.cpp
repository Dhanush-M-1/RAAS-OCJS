#include <iostream>
using namespace std;

int main() {
  int card[4][13] = { {0} };
  char suit[4] = { 'S','H', 'C', 'D' };
  int n, a;
  char c;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> c >> a;
    if (c == 'S') card[0][a - 1]++;
    else if (c == 'H') card[1][a - 1]++;
    else if (c == 'C') card[2][a - 1]++;
    else card[3][a - 1]++;
  }
  for (int i = 0; i < 4; i++) {
    for (int j = 0; j < 13; j++) {
      if (card[i][j] == 0) {
        cout << suit[i] << " " << j + 1 << "\n";
      }
    }
  }
  return 0;
}
