#include <bits/stdc++.h>
using namespace std;
int main() {
  long long a, b, c, t, k;
  cin >> a >> b >> c;
  t = a * c;
  t = t - b * c;
  k = t / b;
  if (t % b != 0) k++;
  cout << k << endl;
}
