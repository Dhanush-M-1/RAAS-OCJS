#include <bits/stdc++.h>
using namespace std;
const long long INF = 1e9;
const long long N = 1e2 + 2;
const long long mod = 1e9 + 7;
const long double eps = 1E-7;
int a[2], o, f, s, p;
int main() {
  ios_base::sync_with_stdio(0);
  cout << "? 0 0" << endl;
  cin >> o;
  if (o == 0) o = 1;
  if (o == -1) p = 1;
  for (int i = 29; i >= 0; i--) {
    a[p] += (1 << i);
    cout << "? " << a[0] << " " << a[1] << endl;
    cin >> f;
    a[p] -= (1 << i);
    cout << "? " << a[0] + (1 << i) << " " << a[1] + (1 << i) << endl;
    cin >> s;
    if (f == 0) a[p] += (1 << i);
    if (f == o && s == -o) a[p] += (1 << i);
    if (f == -o && s == 0) a[0] += (1 << i), a[1] += (1 << i);
    if (f == -o && s == o) a[0] += (1 << i), a[1] += (1 << i);
    if (f == -o && s == -o) a[p] += (1 << i), p = (1 - p), o = -o;
  }
  cout << "! " << a[0] << " " << a[1] << endl;
}
