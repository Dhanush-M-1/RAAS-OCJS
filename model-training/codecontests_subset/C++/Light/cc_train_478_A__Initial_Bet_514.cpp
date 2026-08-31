#include <bits/stdc++.h>
using namespace std;
int main() {
  int a;
  int s = 0;
  for (int i = 0; i < 5; i++) cin >> a, s += a;
  if (!(s % 5) && (s / 5) > 0)
    cout << s / 5 << "\n";
  else
    cout << "-1\n";
  return 0;
}
