#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m, day = 1;
  cin >> n >> m;
  while (true) {
    if (n == 0) return cout << day - 1, 0;
    n--;
    if (day % m == 0) n++;
    day++;
  }
  cout << day << endl;
  return 0;
}
