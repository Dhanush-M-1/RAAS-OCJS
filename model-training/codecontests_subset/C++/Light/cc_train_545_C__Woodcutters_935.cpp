#include <bits/stdc++.h>
using namespace std;
int loc[100005], hgt[100005];
int main() {
  int n, ans = 2;
  cin >> n;
  for (int i = 0; i < n; i++) cin >> loc[i] >> hgt[i];
  for (int i = 1; i < n - 1; i++) {
    if (loc[i] - loc[i - 1] > hgt[i]) {
      ans++;
    } else if (loc[i + 1] - loc[i] > hgt[i]) {
      ans++;
      loc[i] += hgt[i];
    }
  }
  if (n == 1)
    cout << 1;
  else
    cout << ans;
}
