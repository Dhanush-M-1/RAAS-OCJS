#include <bits/stdc++.h>
using namespace std;
int n, a, b, temp;
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> temp;
    if (temp == 100)
      b++;
    else
      a++;
  }
  if (b % 2 == 1 || (a % 2 == 1 && b < 2))
    cout << "NO" << endl;
  else
    cout << "YES" << endl;
  return 0;
}
