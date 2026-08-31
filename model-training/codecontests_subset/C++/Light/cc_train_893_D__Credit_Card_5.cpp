#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n, d;
  cin >> n >> d;
  long long int ar[n], maxbalance_future[n], bal_that_eve[n],
      val = 0, temp = 0, flag = 0, count = 0;
  vector<int> days_to_check;
  for (int i = 0; i < n; i++) {
    cin >> ar[i];
    if (ar[i] == 0) days_to_check.push_back(i);
    val += ar[i];
    bal_that_eve[i] = val;
    if (val > d) flag = 1;
  }
  temp = LLONG_MIN;
  for (int i = n - 1; i >= 0; i--) {
    temp = max(temp, bal_that_eve[i]);
    maxbalance_future[i] = temp;
  }
  val = 0;
  long long int total_extra = 0;
  long long int offset = 0;
  int x = days_to_check.size();
  for (int i = 0; i < x; i++) {
    int j = days_to_check[i];
    if (bal_that_eve[j] + total_extra >= 0)
      continue;
    else {
      val = maxbalance_future[j] + total_extra;
      offset = d - val;
      count++;
      total_extra += offset;
    }
    offset = 0;
    if (bal_that_eve[j] + total_extra < 0) flag = 1;
  }
  if (flag)
    cout << -1;
  else
    cout << count;
}
