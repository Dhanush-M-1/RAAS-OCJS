#include <bits/stdc++.h>
using namespace std;
int main() {
  int countF = 0, countAI = 0, countIN = 0;
  int n;
  int show = 0;
  string game;
  cin >> n;
  cin >> game;
  for (int i = 0; i < n; i++) {
    if (game[i] == 'F')
      countF++;
    else if (game[i] == 'I')
      countIN++;
    else if (game[i] == 'A')
      countAI++;
  }
  if ((countIN == 0 && countAI == 0))
    show = 0;
  else if (countIN == 0)
    show = countAI;
  else if ((countF != 0 && countIN == 1) || (countAI != 0 && countIN == 1))
    show = countIN;
  cout << show;
  return 0;
}
