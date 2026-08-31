#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int home, away;
  int teamColors[2][n];
  int away_uniform = 0;
  for (int i = 0; i < n; i++) {
    cin >> teamColors[0][i] >> teamColors[1][i];
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (teamColors[1][j] == teamColors[0][i]) {
        away_uniform++;
      }
    }
  }
  cout << away_uniform;
}
