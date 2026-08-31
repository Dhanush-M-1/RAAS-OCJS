#include <bits/stdc++.h>
using namespace std;
int main() {
  int players;
  cin >> players;
  int probably = 0;
  int prob_not = 0;
  for (int i = 0; i < players; i++) {
    char status;
    cin >> status;
    if (status == 'I') prob_not++;
    if (status != 'F') probably++;
  }
  if (prob_not == 1 && probably > 1)
    cout << 1 << endl;
  else if (prob_not > 1)
    cout << 0 << endl;
  else
    cout << probably << endl;
  cout << endl;
}
