#include <iostream>
using namespace std;

const int d_num = 4;
const int num = 13;

int main() {
  char design[d_num] = {'S', 'H', 'C', 'D'};
  bool hasCards[d_num][num] = {false};
  int n;
  cin >> n;
  char d;
  int e;
  for (int i = 0; i < n; i++) {
    cin >> d;
    cin >> e;
    for (int j = 0; j < d_num; j++) {
      if (design[j] == d) hasCards[j][e-1] = true;
    }
  }
  for (int k = 0; k < d_num; k++) {
    for (int l = 0; l < num; l++) {
      if (hasCards[k][l] == false) cout << design[k] << " " << l + 1 << endl;
    }
  }
  return 0;
}