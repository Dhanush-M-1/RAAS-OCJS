#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false), cin.tie(nullptr);
  vector<int> v(5);
  for (auto &p : v) {
    cin >> p;
  }
  int sum = accumulate(v.begin(), v.end(), 0);
  if (sum == 0)
    cout << -1;
  else {
    double avg = double(sum) / 5;
    if (avg == sum / 5)
      cout << avg;
    else
      cout << -1;
  }
  return 0;
}
