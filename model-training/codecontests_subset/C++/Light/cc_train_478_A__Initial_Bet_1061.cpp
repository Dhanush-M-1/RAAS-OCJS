#include <bits/stdc++.h>
using namespace std;
int n, a, b;
int main() {
  for (int i = 1; i <= 5; i++) cin >> a, b += a;
  if (b == 0)
    cout << -1;
  else if (b % 5 == 0)
    cout << b / 5;
  else
    cout << -1;
}
