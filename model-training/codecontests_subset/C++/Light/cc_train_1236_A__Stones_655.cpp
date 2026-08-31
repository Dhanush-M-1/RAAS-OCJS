#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  int t, n, i, j, k, answer = 0;
  cin >> t;
  while (t--) {
    cin >> i >> j >> k;
    answer = 0;
    while (k > 1 && j > 0) {
      k -= 2;
      j--;
      answer += 3;
    }
    while (j > 1 && i > 0) {
      j -= 2;
      i--;
      answer += 3;
    }
    cout << answer << endl;
  }
}
