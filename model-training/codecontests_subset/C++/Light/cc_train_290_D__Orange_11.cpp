#include <bits/stdc++.h>
using namespace std;
int main() {
  string tmp;
  int n;
  cin >> tmp >> n;
  for (int i = 0; i < tmp.length(); i++) {
    if ((tmp[i] >= 'a') && ((tmp[i] < ('a' + n))))
      tmp[i] = (tmp[i] - 'a') + 'A';
    else if ((tmp[i] >= 'A' + n) && ((tmp[i] <= ('Z'))))
      tmp[i] = (tmp[i] - 'A') + 'a';
  }
  cout << tmp;
  return 0;
}
