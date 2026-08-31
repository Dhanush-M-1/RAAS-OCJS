#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, A = 0, F = 0, I = 0;
  char S[200005];
  cin >> n;
  cin >> S;
  for (int i = 0; i < n; i++) {
    if (S[i] == 'A')
      A++;
    else if (S[i] == 'I')
      I++;
  }
  if (I == 0) {
    cout << A << endl;
    return 0;
  }
  if (I == 1) {
    cout << 1 << endl;
    return 0;
  } else
    cout << 0 << endl;
  return 0;
}
