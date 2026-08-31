#include <bits/stdc++.h>
using namespace std;
int main() {
  ios ::sync_with_stdio(0);
  cin.tie(0);
  long long int j = 0, n;
  cin >> n;
  string s;
  cin >> s;
  for (long long int i = 0; i <= n - 1; i++) {
    if (s[i] == '8') {
      j++;
    }
  }
  n = n / 11;
  if (n <= j) {
    cout << n << endl;
  } else
    cout << j << endl;
  return 0;
}
