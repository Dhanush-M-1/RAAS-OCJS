#include <bits/stdc++.h>
#pragma GCC optimize "trapv"
using namespace std;
void solveEachTest(long long int T35TC453N = 1) {
  long long int n;
  cin >> n;
  vector<long long int> arr(n);
  for (auto &V3C_I7 : (arr)) cin >> (V3C_I7);
  if (arr[0] + arr[1] <= arr[n - 1]) {
    cout << "1 2 " << n;
  } else {
    cout << "-1";
  }
  cout << "\n";
  return;
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.precision(10);
  long long int T3X0 = 0, T353 = 1;
  cin >> (T3X0);
  T353 = T3X0;
  while (T3X0--) solveEachTest(T353 - T3X0);
  return 0;
}
