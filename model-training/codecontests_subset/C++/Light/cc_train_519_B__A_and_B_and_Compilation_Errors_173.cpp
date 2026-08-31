#include <bits/stdc++.h>
using namespace std;
const int N = 2 * 1e5 + 10;
long long res;
long long a[N];
void solve() {
  long long n, x;
  cin >> n;
  long long a = 0, b = 0, c = 0;
  for (long long i = 0; i < n; i++) {
    cin >> x;
    a += x;
  }
  for (long long i = 0; i < n - 1; i++) {
    cin >> x;
    b += x;
  }
  for (long long i = 0; i < n - 2; i++) {
    cin >> x;
    c += x;
  }
  cout << a - b << "\n";
  cout << b - c << "\n";
}
int main(int argc, char const *argv[]) {
  ios_base::sync_with_stdio(0);
  cin.tie(NULL);
  cout.tie(NULL);
  long long t = 1;
  while (t--) {
    solve();
  }
  return 0;
}
