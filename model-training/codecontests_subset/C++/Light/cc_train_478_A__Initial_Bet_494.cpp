#include <bits/stdc++.h>
using namespace std;
using ll = long long;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0), cout.tie(0);
  int x;
  int sum = 0;
  for (int i = 0; i < 5; i++) {
    cin >> x;
    sum += x;
  }
  if (sum % 5 == 0 && sum != 0) {
    cout << sum / 5 << "\n";
  } else {
    cout << "-1"
         << "\n";
  }
  return 0;
}
