#include <bits/stdc++.h>
using namespace std;
int main() {
  int numOfComparisons, HomeUniform, GuestUniform, count = 0;
  cin >> numOfComparisons;
  int *Home = new int[numOfComparisons];
  int *Guest = new int[numOfComparisons];
  for (int i = 0; i < numOfComparisons; i++) {
    cin >> Home[i] >> Guest[i];
  }
  for (int i = 0; i < numOfComparisons; i++) {
    for (int j = 0; j < numOfComparisons; j++) {
      if (Home[i] == Guest[j]) count++;
    }
  }
  cout << count;
  return 0;
}
