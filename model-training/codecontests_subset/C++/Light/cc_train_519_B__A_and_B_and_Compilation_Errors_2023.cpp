#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
int main() {
  int n;
  cin >> n;
  int x, a1 = 0, a2 = 0, a3 = 0;
  for (int i = 0; i < n; i++) cin >> x, a1 += x;
  ;
  for (int i = 0; i < n - 1; i++) cin >> x, a2 += x;
  ;
  cout << a1 - a2 << endl;
  for (int i = 0; i < n - 2; i++) cin >> x, a3 += x;
  ;
  cout << a2 - a3 << endl;
  return 0;
}
