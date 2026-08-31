#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, x, sa = 0, sb = 0, sc = 0;
  cin >> n;
  for (int i = 0; i < n; i++) cin >> x, sa += x;
  for (int i = 0; i < n - 1; i++) cin >> x, sb += x;
  for (int i = 0; i < n - 2; i++) cin >> x, sc += x;
  cout << sa - sb << " " << sb - sc << endl;
  return 0;
}
