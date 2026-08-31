#include <bits/stdc++.h>
using namespace std;
int n, a, b;
int main() {
  cin >> n;
  while (cin >> n) {
    if (n == 100)
      a++;
    else
      b++;
  }
  if ((a % 2) || ((b % 2) && (!a)))
    cout << "NO";
  else
    cout << "YES";
  return 0;
}
