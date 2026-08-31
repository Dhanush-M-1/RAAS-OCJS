#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int sum = 0;
  char s;
  for (int i = 0; i < n; i++) {
    cin >> s;
    if (s == '8') sum++;
  }
  sum = min(sum, n / 11);
  cout << sum << endl;
  return 0;
}
