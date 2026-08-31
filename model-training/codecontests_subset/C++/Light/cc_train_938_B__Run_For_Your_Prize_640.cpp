#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int mid = 1000000 / 2;
  int min_mid = INT_MAX, max_mid = INT_MIN;
  int flag = 0, flag1 = 0;
  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    if (x > mid) {
      flag = 1;
      min_mid = min(min_mid, x);
    } else if (x < min_mid) {
      flag1 = 1;
      max_mid = max(max_mid, x);
    }
  }
  int time;
  if (flag == 0) {
    time = max_mid - 1;
  } else if (flag1 == 0) {
    time = (long long)1000000 - (long long)min_mid;
  } else {
    time = max((long long)1000000 - (long long)min_mid, (long long)max_mid - 1);
  }
  cout << time;
  return 0;
}
