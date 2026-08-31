#include <bits/stdc++.h>
using namespace std;
int A[100010];
int main() {
  ios_base::sync_with_stdio(false);
  int n, d;
  cin >> n >> d;
  long long amount = 0;
  int res = 0;
  for (int i = 0; i < n; ++i) {
    cin >> A[i];
    if (A[i] == 0) {
      if (amount < 0) amount = 0;
    }
    amount += A[i];
    if (amount > d) res = -1;
  }
  if (res == -1) {
    cout << res << "\n";
    return 0;
  }
  amount = 0;
  long long pico = 0;
  res = 0;
  for (int i = 0; i < n; ++i) {
    if (A[i] == 0) {
      if (amount < 0) {
        if (res > 0 && d - pico >= -amount) {
          pico -= amount;
          amount = 0;
        } else {
          amount = 0;
          pico = 0;
          res++;
        }
      }
    }
    amount += A[i];
    pico = max(amount, pico);
  }
  cout << res << "\n";
  return 0;
}
