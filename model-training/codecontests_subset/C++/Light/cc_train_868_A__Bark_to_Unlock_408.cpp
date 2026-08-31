#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i;
  bool p1 = false, p0 = false;
  char w[2];
  cin >> w;
  cin >> n;
  char A[n][2];
  for (i = 0; i < n; i++) cin >> A[i];
  i = 0;
  while (i < n) {
    if (w[0] == A[i][0] && w[1] == A[i][1]) break;
    if (w[0] == A[i][1]) p0 = true;
    if (w[1] == A[i][0]) p1 = true;
    if (p0 && p1) break;
    i++;
  }
  if (i == n)
    cout << "NO" << endl;
  else
    cout << "YES" << endl;
  return 0;
}
