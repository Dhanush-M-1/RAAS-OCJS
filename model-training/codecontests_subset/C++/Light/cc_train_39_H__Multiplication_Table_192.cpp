#include <bits/stdc++.h>
using namespace std;
void input() {}
void base(long long int a, long long int n) {
  if (a / n > 0) cout << a / n;
  cout << a % n << " ";
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  input();
  long long int n;
  cin >> n;
  long long int arr[n][n];
  for (long long int i = 1; i < n; i++) {
    for (long long int j = 1; j < n; j++) {
      base(i * j, n);
    }
    cout << "\n";
  }
}
