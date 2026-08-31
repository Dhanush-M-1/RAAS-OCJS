#include <bits/stdc++.h>
using namespace std;
const int INF = INT_MAX;
const long long INFL = LLONG_MAX;
int main() {
  long long a, b, c;
  ios_base::sync_with_stdio(0);
  cin >> a >> b >> c;
  long long up = (a - b) * c;
  if (up % b == 0)
    cout << up / b << endl;
  else
    cout << (up / b) + 1 << endl;
  return 0;
}
