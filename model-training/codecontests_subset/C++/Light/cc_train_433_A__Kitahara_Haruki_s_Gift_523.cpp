#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, s = 0, c = 0;
  cin >> n;
  int a[n];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    s += a[i];
    if (a[i] == 200) c++;
  }
  s = s / 100;
  if (n == c && n % 2 != 0)
    cout << "NO";
  else if (s % 2 == 0)
    cout << "YES";
  else
    cout << "NO";
}
