#include <bits/stdc++.h>
using namespace std;
const int INF = 1 << 30;
const double EPS = 1e-7;
int main() {
  ios::sync_with_stdio(false);
  int n;
  cin >> n;
  int A = 0, F = 0, I = 0;
  for (int i = 0; i < n; i++) {
    char c;
    cin >> c;
    if (c == 'I')
      I++;
    else if (c == 'F')
      F++;
    else
      A++;
  }
  if (I == 1)
    cout << 1 << endl;
  else if (I > 1)
    cout << 0 << endl;
  else
    cout << A << endl;
  return 0;
}
