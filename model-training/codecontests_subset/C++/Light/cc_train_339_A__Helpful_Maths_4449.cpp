#include <bits/stdc++.h>
using namespace std;
int main() {
  int problem[101];
  string problemS;
  cin >> problemS;
  for (uint16_t counter = 0; counter < (problemS.length() + 1) / 2; counter++) {
    problem[counter] = (int)problemS[counter * 2] - ('1' - 1);
  }
  sort(problem, problem + ((problemS.length() + 1) / 2));
  for (uint16_t counter = 0; counter < (problemS.length() + 1) / 2; counter++) {
    cout << problem[counter];
    if (counter != ((problemS.length() + 1) / 2) - 1) {
      cout << "+";
    }
  }
  return 0;
}
