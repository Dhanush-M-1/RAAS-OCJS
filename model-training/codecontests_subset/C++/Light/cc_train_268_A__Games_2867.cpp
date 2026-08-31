#include <bits/stdc++.h>
using namespace std;
int color[60];
int main() {
  int num = 0, c = 0;
  cin >> num;
  for (int i = 0; i < 2 * num; i++) {
    cin >> color[i];
  }
  for (int i = 0; i < (2 * num) - 2; i++) {
    for (int j = 0; j <= num - 2; j++) {
      if (i % 2 == 0) {
        if (color[i] == color[i + 3 + (2 * j)]) {
          c++;
        }
      } else {
        if (color[i] == color[i + 1 + (2 * j)]) {
          c++;
        }
      }
    }
  }
  cout << c;
  return 0;
}
