#include <bits/stdc++.h>
using namespace std;
long long int q;
void solve(long long int x) {
  for (long long int i = 2; i * i <= x; i++) {
    if (x % i == 0) {
      long long int temp = x / i;
      for (long long int j = 2; j * j <= temp; j++) {
        if (temp % j == 0) {
          cout << 1 << "\n";
          cout << i * j;
          return;
        }
      }
      cout << 2;
      return;
    }
  }
  cout << 1 << "\n";
  cout << 0;
  return;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> q;
  if (q == 1) {
    cout << 1 << "\n";
    cout << 0;
    return 0;
  }
  solve(q);
  return 0;
}
