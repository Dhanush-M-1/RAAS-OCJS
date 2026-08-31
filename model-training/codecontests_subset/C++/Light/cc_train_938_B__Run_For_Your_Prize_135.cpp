#include <bits/stdc++.h>
using namespace std;
int main() {
  long n;
  cin >> n;
  vector<long> vect(n + 2);
  for (int i = 1; i <= n; i++) {
    cin >> vect[i];
  }
  long maxm = *max_element(vect.begin(), vect.end());
  long res = INT_MAX;
  vect[0] = 1;
  vect[n + 1] = 1000000;
  for (int i = 0; i <= n; i++) {
    res = min(res, max(vect[i] - vect[0], vect[n + 1] - vect[i + 1]));
  }
  cout << res;
  return 0;
}
