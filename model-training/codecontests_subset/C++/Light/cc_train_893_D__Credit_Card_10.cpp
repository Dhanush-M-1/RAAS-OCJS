#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e5 + 10;
int ma[maxn];
int en[maxn];
int add = 0;
int main() {
  std::ios::sync_with_stdio(false);
  int n, d;
  cin >> n >> d;
  int sum = 0;
  int mx = -40000000;
  int op = 0;
  for (int i = 0; i < n; i++) {
    int in;
    cin >> in;
    if (in != 0) {
      sum += in;
      mx = max(mx, sum);
      if (sum > d) {
        cout << "-1" << endl;
        return 0;
      }
    } else {
      if (sum >= 0) continue;
      ma[op] = mx;
      en[op++] = sum;
      sum = 0;
      mx = -400000000;
    }
  }
  int cnt = 0;
  for (int i = 0; i < op; i++) {
    if (min(add, d - ma[i]) < abs(en[i])) {
      cnt++;
      add = d;
    } else {
      add = min(add, d - ma[i]) - abs(en[i]);
    }
  }
  cout << cnt << endl;
}
