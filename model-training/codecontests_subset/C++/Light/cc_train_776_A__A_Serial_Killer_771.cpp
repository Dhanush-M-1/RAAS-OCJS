#include <bits/stdc++.h>
using namespace std;
string names[2];
int n;
string killed, nextDay;
void operate() {
  for (int i = 0; i < 2; i++) {
    cout << names[i] << " ";
    if (names[i].compare(killed) == 0) {
      names[i] = nextDay;
    }
  }
  cout << "\n";
}
int main() {
  for (int i = 0; i < 2; i++) {
    cin >> names[i];
  }
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> killed;
    cin >> nextDay;
    operate();
  }
  for (int i = 0; i < 2; i++) {
    cout << names[i] << " ";
  }
  return 0;
}
