#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, ctr{};
  cin >> n;
  string vec;
  cin >> vec;
  int likh = count(vec.begin(), vec.end(), '8');
  if (likh > 0) {
    int m = min(likh, n % 11);
    int len = n - m;
    len = len / 10;
    ctr = min(len, likh);
  }
  cout << ctr << "\n";
  return 0;
}
