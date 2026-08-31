#include <bits/stdc++.h>
using namespace std;
int main() {
  bool arr[105]{false};
  int numOfturnedOnBulb;
  int numOfBulbs;
  int numOfButtons;
  int turnedOnBulbs;
  bool allTurnedOn = true;
  cin >> numOfButtons >> numOfBulbs;
  for (int i = 0; i < numOfButtons; ++i) {
    cin >> turnedOnBulbs;
    for (int j = 0; j < turnedOnBulbs; ++j) {
      cin >> numOfturnedOnBulb;
      arr[numOfturnedOnBulb] = true;
    }
  }
  for (int i = 1; i <= numOfBulbs; ++i) {
    if (arr[i] == 0) allTurnedOn = false;
  }
  if (allTurnedOn)
    cout << "YES";
  else
    cout << "NO";
  return 0;
}
