#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  cin >> n >> x >> y;
  int req = n * y;
  int remi = req % 100;
  req = req / 100;
  if (remi) {
    req++;
  }
  req = req - x;
  if (req < 0) {
    cout << "0\n";
    return 0;
  }
  cout << req << endl;
  return 0;
}
