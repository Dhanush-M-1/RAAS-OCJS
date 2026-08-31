#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  cin >> n >> x >> y;
  cout << max(0, (y * n + 99) / 100 - x) << endl;
}
