#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  int n, cnt = 0;
  char c;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> c;
    if (c == '8') cnt++;
  }
  cout << min(cnt, (n - (n / 10)) / 10) << "\n";
  return 0;
}
