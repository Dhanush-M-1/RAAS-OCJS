#include <bits/stdc++.h>
using namespace std;
vector<long long> F;
int main() {
  long long x, i;
  cin >> x;
  for (i = 2; i * i <= x; i++)
    if (x % i == 0) {
      x /= i;
      F.push_back(i--);
      if (F.size() > 2) break;
    }
  if (x > 1) F.push_back(x);
  if (F.size() < 2)
    cout << "1\n0";
  else if (F.size() < 3)
    cout << "2";
  else
    cout << "1\n" << F[0] * F[1];
}
