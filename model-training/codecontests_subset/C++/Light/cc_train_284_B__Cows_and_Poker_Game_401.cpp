#include <bits/stdc++.h>
using namespace std;
int main() {
  int num;
  cin >> num;
  int atmosphere(0), temp(0);
  char mode;
  for (int i = 0; i < num; i++) {
    cin >> mode;
    if (mode == 'I') atmosphere++;
    if (mode == 'A') temp++;
  }
  if (atmosphere == 0) cout << temp;
  if (atmosphere == 1) cout << 1;
  if (atmosphere >= 2) cout << 0;
  return 0;
}
