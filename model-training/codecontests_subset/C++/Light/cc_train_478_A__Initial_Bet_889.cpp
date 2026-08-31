#include <bits/stdc++.h>
using namespace std;
int main() {
  int C1, C2, C3, C4, C5;
  cin >> C1 >> C2 >> C3 >> C4 >> C5;
  if (C1 + C2 + C3 + C4 + C5 == 0) {
    cout << "-1";
  } else if ((C1 + C2 + C3 + C4 + C5) % 5 == 0) {
    cout << ((C1 + C2 + C3 + C4 + C5) / 5);
  } else {
    cout << "-1";
  }
}
