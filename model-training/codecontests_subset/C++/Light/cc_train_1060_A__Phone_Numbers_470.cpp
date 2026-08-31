#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, b = 0;
  char c;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> c;
    if (c == '8') b++;
  }
  cout << min(b, n / 11) << endl;
  return 0;
}
