#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  string a, b, c;
  cin >> n >> a;
  sort(a.begin(), a.end());
  for (int i = 0; i < a.size(); i += n) b += a[i];
  for (int i = 0; i < n; i++) c += b;
  b = c;
  sort(b.begin(), b.end());
  if (b != a)
    cout << -1;
  else
    cout << c;
}
