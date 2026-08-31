#include <bits/stdc++.h>
using namespace std;
double n, y;
int x;
int main() {
  cin >> n >> x >> y;
  if (x >= ceil(n * (y / 100)))
    cout << "0" << endl;
  else
    cout << ceil(n * (y / 100)) - x;
  return 0;
}
