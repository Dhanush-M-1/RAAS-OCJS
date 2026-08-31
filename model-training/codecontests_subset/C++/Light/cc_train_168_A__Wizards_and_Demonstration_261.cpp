#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y, people_needed = 0;
  cin >> n >> x >> y;
  people_needed = ceil(double(y) * n / 100);
  if (people_needed <= x)
    cout << "0\n";
  else
    cout << people_needed - x << endl;
  return 0;
}
