#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  char s;
  int I = 0, A = 0;
  for (int i = 0; i < n; i++) {
    cin >> s;
    if (s == 'I') I++;
    if (s == 'A') A++;
  }
  if (I == 0) {
    cout << A;
  }
  if (I == 1) {
    cout << 1;
  }
  if (I > 1) {
    cout << 0;
  }
  return 0;
}
