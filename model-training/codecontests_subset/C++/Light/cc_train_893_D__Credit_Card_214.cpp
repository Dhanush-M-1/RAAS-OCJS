#include <bits/stdc++.h>
using namespace std;
bool db = false;
const long long INF = 1e18 + 1;
const int maxn = 1e5 + 1;
int n, d;
int a[maxn];
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> d;
  vector<int> v;
  for (int i = 0; i < n; i++) cin >> a[i];
  int ans = 0;
  int balance = 0;
  int mx_balance = 0;
  int x;
  for (int i = 0; i < n; i++) {
    x = a[i];
    if (x == 0) continue;
    balance += x;
    if (balance > d) {
      ans = -1;
      break;
    }
    mx_balance = max(mx_balance, balance);
    if (balance < 0 and i + 1 < n and a[i + 1] == 0) {
      if (ans == 0) {
        ans++;
        balance = 0;
        mx_balance = 0;
        continue;
      }
      if (-balance <= d - mx_balance) {
        mx_balance += (-balance);
        balance = 0;
      } else {
        balance = 0;
        mx_balance = 0;
        ans++;
      }
    }
  }
  cout << ans << endl;
  return 0;
}
