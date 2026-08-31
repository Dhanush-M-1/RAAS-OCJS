#include <bits/stdc++.h>
using namespace std;
int main() {
  string card;
  int cnt = 0;
  int n, i, ans = 0;
  cin >> n;
  cin >> card;
  for (int i = 0; i < n; i++)
    if (card[i] == '8') cnt++;
  int other = n - cnt;
  for (i = cnt; i > 0;) {
    i--;
    if (other >= 10) {
      other -= 10;
      ans++;
    } else if (other + i >= 10) {
      i -= (10 - other);
      other = 0;
      ans++;
    }
  }
  cout << ans << "\n";
  return 0;
}
