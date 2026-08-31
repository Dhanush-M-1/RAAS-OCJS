#include <bits/stdc++.h>
using namespace std;
int main() {
  int T;
  cin >> T;
  while (T--) {
    int n;
    cin >> n;
    int A, B, C;
    cin >> A >> B;
    for (int i = 3; i <= n - 1; i++) cin >> C;
    cin >> C;
    if (A + B <= C)
      cout << "1 2 " << n;
    else
      cout << -1;
    cout << "\n";
  }
}
