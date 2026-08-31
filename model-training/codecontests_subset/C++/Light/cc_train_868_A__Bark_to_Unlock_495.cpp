#include <bits/stdc++.h>
using namespace std;
bool top = 0;
bool bottom = 0;
int main() {
  string pass;
  cin >> pass;
  int t;
  cin >> t;
  string a;
  for (int i = 1; i <= t; i++) {
    cin >> a;
    if (a[0] == pass[1]) bottom = 1;
    if (a[1] == pass[0]) top = 1;
    if ((a[0] == pass[0]) && (a[1] == pass[1])) {
      bottom = 1;
      top = 1;
    }
  }
  if (top && bottom)
    cout << "yes";
  else
    cout << "no";
}
