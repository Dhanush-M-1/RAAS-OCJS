#include <bits/stdc++.h>
using namespace std;
int main() {
  int teams;
  int currentArrayIndex = 0;
  cin >> teams;
  int teamsColor[teams * 2];
  for (int i = 0; i < teams; i++) {
    for (int j = 0; j < 2; j++) {
      cin >> teamsColor[currentArrayIndex];
      currentArrayIndex++;
    }
  }
  int arrSize = sizeof(teamsColor) / sizeof(teamsColor[0]);
  int lastTeamColor[2] = {teamsColor[0], teamsColor[1]};
  int totalCount = 0;
  for (int i = 0; i < arrSize; i++) {
    if (i % 2 == 0) {
      for (int k = 0; k < arrSize; k++) {
        if (k % 2 != 0) {
          if (teamsColor[k] == teamsColor[i]) totalCount++;
        }
      }
      lastTeamColor[0] = teamsColor[i - 1];
      lastTeamColor[1] = teamsColor[i];
    }
  }
  cout << totalCount;
}
