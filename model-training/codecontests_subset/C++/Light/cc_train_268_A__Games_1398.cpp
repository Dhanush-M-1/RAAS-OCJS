#include <bits/stdc++.h>
using namespace std;
int main() {
  int teams = 0;
  cin >> teams;
  int uni[teams][2];
  int ch = 0;
  for (int i = 0; i < teams; i++) {
    cin >> uni[i][0];
    cin >> uni[i][1];
  }
  for (int i = 0; i < teams - 1; i++) {
    for (int j = i + 1; j < teams; j++) {
      if (uni[i][0] == uni[j][1]) ch++;
      if (uni[i][1] == uni[j][0]) ch++;
    }
  }
  cout << ch;
  return 0;
}
