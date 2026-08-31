#include <bits/stdc++.h>
using namespace std;
bool sortbyfirstandsec(const pair<int, int> &a, const pair<int, int> &b) {
  if (a.first == b.first) return (a.second > b.second);
  return a.first < b.first;
}
long long fact(long long int a, long long int b) {
  if (b == 0)
    return a;
  else
    return fact(b, a % b);
}
int main() {
  long long int n, m, i, j, k, l, w = 0, a, b, c, y, p;
  cin >> n >> a >> b >> c;
  a = a / 2;
  for (i = 0; i <= c; i++) {
    if (n - 2 * i <= a + b) {
      for (j = 0; j <= b; j++) {
        if (n - 2 * i - j <= a && n - 2 * i - j >= 0) {
          w++;
        }
      }
    }
  }
  cout << w;
  return 0;
}
