#include <bits/stdc++.h>
using namespace std;
int main() {
  int n_days, limit, balance = 0, min_deposits = 0, trans[100000],
                     exceed_limit = 0;
  int max_deposits[100000], temp_max, n_deposits = 0, deposit_index,
                                      running_dep = 0;
  cin >> n_days >> limit;
  for (int j = 0; j < n_days; j++) {
    cin >> trans[j];
    balance += trans[j];
    if (!trans[j]) {
      n_deposits++;
    }
  }
  deposit_index = n_deposits;
  temp_max = limit - balance;
  for (int j = n_days - 1; j >= 0; j--) {
    if (!trans[j]) {
      max_deposits[deposit_index - 1] = max(-balance, temp_max);
      deposit_index--;
    }
    balance -= trans[j];
    temp_max = min(temp_max, limit - balance);
  }
  running_dep = 0;
  for (int j = 0; j < n_days; j++) {
    balance += trans[j];
    if (!trans[j]) {
      if (balance < 0) {
        min_deposits++;
        balance += max(0, max_deposits[deposit_index] - running_dep);
        running_dep = max(running_dep, max_deposits[deposit_index]);
      }
      deposit_index++;
    }
    if (balance > limit) {
      exceed_limit = 1;
      break;
    }
  }
  if (exceed_limit) {
    cout << -1 << endl;
  } else {
    cout << min_deposits << endl;
  }
  return 0;
}
