#include <iostream>

using namespace std;

int main() {
  int has[4][13] = {0};
  int n, r;
  char s;
  cin >> n;

  for (int i = 0; i < n; ++i) {
    cin >> s >> r;
    has[(s == 'H') + (s == 'C') * 2 + (s == 'D') * 3][r - 1] = 1;
  }

  for (int i = 0; i < 4; ++i) {
    for (int j = 0; j < 13; ++j) {
      if (!has[i][j]) {
        cout << "SHCD"[i] << ' ' << (j + 1) << endl;
      }
    }
  }
  return 0;
} 

