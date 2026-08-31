#include <bits/stdc++.h>
using namespace std;
const long long N = 0xff;
long long n, c, x[N], answer;
void smx(long long &a, const long long &b) {
  if (a < b) {
    a = b;
  }
}
int32_t main() {
  cin >> n >> c;
  for (long long i = 0; i < n; ++i) {
    cin >> x[i];
    if (i) {
      smx(answer, x[i - 1] - x[i] - c);
    }
  }
  cout << answer << endl;
  return 0;
}
