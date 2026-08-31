#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  string cows;
  cin >> cows;
  int cou = 0;
  sort(cows.begin(), cows.end());
  for (int i = 0; i < cows.size(); i++) {
    if (cows[i] == 'A' || cows[i] == 'I') {
      if (!binary_search(cows.begin(), cows.begin() + i, 'I') &&
          !binary_search(cows.begin() + i + 1, cows.end(), 'I'))
        cou++;
    }
  }
  cout << cou << endl;
  return 0;
}
