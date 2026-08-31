#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("O3")
#pragma GCC optimize("Ofast")
#pragma GCC target("avx2,fma")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
#pragma GCC target("avx2")
#pragma GCC optimization("unroll-loops")
#pragma comment(linker, "/STACK: 20000000005")
bool tc = 1;
void run_case() {
  long long a, b, c;
  cin >> a >> b >> c;
  long long count{0};
  for (long long i = 0;; i++) {
    if (b != 0 && c != 0 && c >= 2) {
      b = b - 1;
      c = c - 2;
      count = count + 3;
    } else if (a != 0 && b != 0 && b >= 2) {
      a = a - 1;
      b = b - 2;
      count = count + 3;
    } else {
      break;
    }
  }
  cout << count << endl;
}
int32_t main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  if (tc) {
    long long t;
    cin >> t;
    while (t--) run_case();
  } else
    run_case();
  return 0;
}
