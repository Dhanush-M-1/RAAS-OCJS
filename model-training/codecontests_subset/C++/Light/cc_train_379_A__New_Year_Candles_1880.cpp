#include <bits/stdc++.h>
using namespace std;
long long n, m;
void in() { cin >> n >> m; }
void out() {
  long long sum{0}, r{0};
  while (n > 0) {
    while (n > 0) {
      sum += n;
      r += n % m;
      n /= m;
    }
    n = r / m;
    r = r % m;
  }
  cout << sum;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long t = 1;
  while (t--) {
    in();
    out();
  }
  return 0;
}
