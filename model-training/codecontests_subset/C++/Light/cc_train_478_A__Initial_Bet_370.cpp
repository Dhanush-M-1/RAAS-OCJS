#include <bits/stdc++.h>
using namespace std;
long long mod = 1000000007;
int main() {
  std::vector<int> c(5);
  int sum = 0;
  for (int i = 0; i < 5; i++) {
    cin >> c[i];
    sum += c[i];
  }
  if (sum % 5 != 0) {
    cout << -1;
  } else if (sum == 0)
    cout << -1;
  else
    cout << sum / 5;
}
