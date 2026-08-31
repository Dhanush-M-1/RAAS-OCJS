#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, d;
  cin >> n >> d;
  long long arr[n + 1], day[n + 1];
  day[0] = 0;
  for (long long i = 1; i <= n; i++) {
    cin >> arr[i];
    day[i] = day[i - 1] + arr[i];
  }
  long long mx[n + 1];
  mx[n] = day[n];
  for (long long i = n - 1; i >= 1; i--) {
    mx[i] = max(mx[i + 1], day[i]);
  }
  long long ans = 0, add = 0;
  for (long long i = 1; i <= n; i++) {
    if (arr[i] == 0 and day[i] + add < 0) {
      add += max(0 - day[i] - add, d - add - mx[i]);
      ans++;
    }
    if (day[i] + add > d) {
      cout << -1 << endl;
      return 0;
    }
  }
  cout << ans << endl;
}
