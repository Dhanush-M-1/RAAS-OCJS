#include <bits/stdc++.h>
using namespace std;
string s;
string numtostring(float num) {
  stringstream stream;
  stream << fixed << setprecision(6) << num;
  s = stream.str();
  return s;
}
int power(int a, int b) {
  int res = 1;
  while (b) {
    if (b % 2) {
      res = (res * a) % 1000000007;
    }
    b /= 2;
    a = (a * a) % 1000000007;
  }
  return res;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  long long i, n, m, p;
  cin >> n;
  m = n - 1;
  p = n - 2;
  int a[n], b[m], c[p];
  for (i = 0; i < n; i++) cin >> a[i];
  for (i = 0; i < m; i++) cin >> b[i];
  for (i = 0; i < p; i++) cin >> c[i];
  sort(a, a + n);
  sort(b, b + m);
  sort(c, c + p);
  for (i = 0; i < n; i++) {
    if (a[i] != b[i]) {
      cout << a[i] << "\n";
      break;
    }
  }
  for (i = 0; i < m; i++) {
    if (b[i] != c[i]) {
      cout << b[i] << "\n";
      break;
    }
  }
  return 0;
}
