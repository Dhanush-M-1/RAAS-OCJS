#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n, x, y;
  cin >> n >> x >> y;
  int temp = (y * n / 100) + ((y * n % 100) ? 1 : 0);
  temp -= x;
  if (temp <= 0)
    cout << "0\n";
  else
    cout << temp << '\n';
  return 0;
}
