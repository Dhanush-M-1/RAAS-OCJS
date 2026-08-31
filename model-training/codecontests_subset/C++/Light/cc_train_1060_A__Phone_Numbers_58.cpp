#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, countOfEight = 0, alongNums = 0;
  string input;
  cin >> n >> input;
  for (int i = 0; i < n; i++) {
    char cha = input[i];
    if (cha == '8') countOfEight++;
  }
  alongNums = n - countOfEight;
  while (alongNums / 10 < countOfEight) {
    alongNums++;
    countOfEight--;
  }
  if (alongNums < 10 || countOfEight == 0)
    cout << 0;
  else {
    alongNums /= 10;
    if (alongNums >= countOfEight)
      cout << countOfEight;
    else {
      cout << alongNums;
    }
  }
}
