#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n, x, y, need;
  cin >> n >> x >> y;
  need = y * n;
  if ((y * n) % 100 == 0) {
    need = (y * n) / 100;
  } else {
    need = (y * n) / 100;
    need++;
  }
  if (need > x) {
    cout << need - x << endl;
  } else {
    cout << "0" << endl;
  }
  return 0;
}
