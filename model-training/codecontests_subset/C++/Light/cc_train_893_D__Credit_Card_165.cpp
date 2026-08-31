#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  long long int d;
  cin >> n >> d;
  vector<int> check_days;
  int a[n];
  long long int prefix_sum[n];
  cin >> a[0];
  if (a[0] == 0) check_days.push_back(0);
  prefix_sum[0] = a[0];
  for (int i = 1; i < n; i++) {
    cin >> a[i];
    if (a[i] == 0) check_days.push_back(i);
    prefix_sum[i] = prefix_sum[i - 1] + a[i];
  }
  int days = 0;
  long long int mi = LLONG_MIN;
  long long int max_balance_after[n];
  for (int i = n - 1; i >= 0; i--) {
    if (prefix_sum[i] > d) {
      cout << -1;
      return 0;
    }
    mi = max(mi, prefix_sum[i]);
    max_balance_after[i] = mi;
  }
  int deposit_val = 0;
  for (int i = 0; i < check_days.size(); i++) {
    int j = check_days[i];
    if (prefix_sum[j] + deposit_val < 0) {
      int new_bal = 0, val_to_deposit = 0;
      new_bal = max_balance_after[j] + deposit_val;
      val_to_deposit = d - new_bal;
      days++;
      deposit_val += val_to_deposit;
      if (prefix_sum[j] + deposit_val < 0) {
        cout << -1;
        return 0;
      }
    }
  }
  cout << days;
  return 0;
}
