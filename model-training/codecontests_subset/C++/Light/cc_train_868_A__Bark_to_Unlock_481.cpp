#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  char ca, cb, da, db;
  bool ba = false, bb = false;
  cin >> ca >> cb >> n;
  while (n--) {
    cin >> da >> db;
    if (da == cb) bb = true;
    if (db == ca) ba = true;
    if (da == ca && db == cb) ba = bb = true;
  }
  if (ba && bb)
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
  return 0;
}
