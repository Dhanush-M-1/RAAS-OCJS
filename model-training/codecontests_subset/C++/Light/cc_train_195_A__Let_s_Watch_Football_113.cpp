#include <bits/stdc++.h>
using namespace std;
int main() {
  long long a, b, c;
  cin >> a >> b >> c;
  long long boss = (b - a) * c;
  boss = abs(boss);
  cout << ceil((double)boss / (double)b) << endl;
  return 0;
}
