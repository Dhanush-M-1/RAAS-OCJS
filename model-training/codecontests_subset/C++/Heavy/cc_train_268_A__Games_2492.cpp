#include <bits/stdc++.h>
using namespace std;
void initialMethod();
int main() {
  int teams = 0;
  int answer = 0;
  cin >> teams;
  int colorArr[teams][2];
  for (int i = 0; i < teams; i++) {
    cin >> colorArr[i][0] >> colorArr[i][1];
  }
  for (int i = 0; i < teams; i++) {
    for (int k = 0; k < teams; k++) {
      if (k == i) continue;
      if (colorArr[i][0] == colorArr[k][1]) answer++;
    }
  }
  cout << answer << endl;
  return 0;
}
void initialMethod() {
  int teams;
  int currentArrayIndex = 0;
  cin >> teams;
  int teamsColor[teams * 2];
  int totalCount = 0;
  int arrSize;
  for (int i = 0; i < teams; i++) {
    for (int j = 0; j < 2; j++) {
      cin >> teamsColor[currentArrayIndex];
      currentArrayIndex++;
    }
  }
  arrSize = sizeof(teamsColor) / sizeof(teamsColor[0]);
  for (int i = 0; i < arrSize; i++) {
    if (i % 2 == 0) {
      for (int k = 0; k < arrSize; k++) {
        if (k % 2 != 0) {
          if (teamsColor[k] == teamsColor[i]) totalCount++;
        }
      }
    }
  }
  cout << totalCount;
}
