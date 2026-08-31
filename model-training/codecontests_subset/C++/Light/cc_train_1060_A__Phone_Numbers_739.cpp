#include <bits/stdc++.h>
using namespace std;
int n, j, k;
string x;
int main() {
  cin >> n >> x;
  j = 0;
  k = n / 11;
  for (int i = 0; i < n; i++) {
    if (x[i] == 56) j++;
  }
  cout << min(j, k);
  return 0;
}
