#include <bits/stdc++.h>
using namespace std;
void go(int x, int k) {
  if (x == 0)
    cout << 0;
  else {
    int nxt = x / k;
    if (nxt != 0) {
      go(nxt, k);
    }
    cout << x % k;
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  int k;
  cin >> k;
  for (int i = 1; i < k; i++) {
    for (int j = 1; j < k; j++) {
      go(i * j, k);
      cout << " ";
    }
    cout << "\n";
  }
  return 0;
}
