#include <bits/stdc++.h>
using namespace std;
int main() {
  long long t;
  cin >> t;
  long long le, re, dis;
  for (int i = 0; i < t; i++) {
    cin >> le >> re >> dis;
    long long le1 = le / dis;
    long long le2 = re / dis;
    if (le % dis == 0)
      le1 = (le / dis - 1) * dis;
    else
      le1 = (le / dis) * dis;
    le2 = (re / dis + 1) * dis;
    if (le1 > 0)
      cout << min(le1, dis) << endl;
    else
      cout << le2 << endl;
  }
  return 0;
}
