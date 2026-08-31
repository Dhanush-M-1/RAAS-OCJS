#include <iostream>
#include <map>
#include <string>
using namespace std;

int main(void) {
  map<string, int> si;
  map<int, string> is;

  si["S"] = 0, si["H"] = 1, si["C"] = 2, si["D"] = 3;
  is[0] = "S", is[1] = "H", is[2] = "C", is[3] = "D";

  int n, col;
  string row;

  int isHas[4][13] = {{0}};

  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> row >> col;
    isHas[si[row]][col - 1] = 1;
  }

  for (int i = 0; i < 4; i++) {
    for (int j = 0; j < 13; j++) {
      if(isHas[i][j] == 0)
        cout << is[i] << " " << j + 1 << endl;
    }
  }
}

