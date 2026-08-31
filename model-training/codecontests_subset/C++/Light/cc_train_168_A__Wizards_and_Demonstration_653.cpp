#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, x, y;
  cin >> n >> x >> y;
  long long res = n * y - x * 100;
  if (res < 0) res = 0;
  long long output = res / 100;
  if (res % 100) output++;
  cout << output << endl;
  return 0;
}
