#include <bits/stdc++.h>
using namespace std;
int main() {
  std::ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int sum = 0, a;
  for (int i = 0; i < 5; i++) {
    cin >> a;
    sum += a;
  }
  if (sum % 5 == 0 and sum != 0)
    cout << sum / 5 << "\n";
  else
    cout << -1 << "\n";
  return 0;
}
