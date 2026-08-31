#include <bits/stdc++.h>
using namespace std;
int A, I, F;
int main() {
  int n, m, i, j, k, sum;
  int x, y;
  int tc, t;
  string str;
  cin >> n >> str;
  for (i = 0; i < n; i++) {
    if (str[i] == 'A')
      A++;
    else if (str[i] == 'I')
      I++;
    else
      F++;
  }
  if (I == 0)
    cout << A;
  else if (I == 1)
    cout << 1;
  else
    cout << 0;
  cout << endl;
  return 0;
}
