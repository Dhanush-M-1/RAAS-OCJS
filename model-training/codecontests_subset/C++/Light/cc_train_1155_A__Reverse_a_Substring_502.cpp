#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, q1, q2;
  char l;
  cin >> n;
  cin >> l;
  q2 = (int)l;
  for (i = 1; i < n; i++) {
    cin >> l;
    q1 = q2;
    q2 = (int)l;
    if (q1 > q2) {
      cout << "YES" << endl << i << ' ' << i + 1;
      return 0;
    }
  }
  cout << "NO";
}
