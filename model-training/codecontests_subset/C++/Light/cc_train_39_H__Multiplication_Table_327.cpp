#include <bits/stdc++.h>
int IntMaxVal = (int)1e20;
long long LongMaxVal = (long long)1e20;
template <typename T>
struct argument_type;
template <typename T, typename U>
struct argument_type<T(U)> {};
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  int n;
  cin >> n;
  ;
  for (int i = 1; i < n - 1 + 1; ++i) {
    for (int j = 1; j < n - 1 + 1; ++j) {
      int x = i * j;
      int d1 = x / n;
      int d2 = x % n;
      if (d1 != 0) cout << d1;
      cout << d2 << ' ';
    }
    cout << endl;
  }
}
