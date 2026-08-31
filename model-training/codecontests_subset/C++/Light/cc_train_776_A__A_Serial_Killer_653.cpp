#include <bits/stdc++.h>
using namespace std;
int main() {
  string choice1, choice2;
  cin >> choice1 >> choice2;
  cout << choice1 << " " << choice2 << "\n";
  int n;
  cin >> n;
  string killed, survived;
  for (int i = 0; i < n; i++) {
    cin >> killed >> survived;
    if (choice1 == killed) {
      cout << choice2 << " " << survived << "\n";
      choice1 = survived;
    } else {
      cout << choice1 << " " << survived << "\n";
      choice2 = survived;
    }
  }
}
