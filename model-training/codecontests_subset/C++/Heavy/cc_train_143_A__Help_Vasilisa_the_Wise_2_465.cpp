#include <bits/stdc++.h>
using namespace std;
long long arr[2][2];
long long r1, r2, c1, c2, d1, d2;
bool check(long long n) {
  arr[0][0] = n;
  arr[1][1] = d1 - n;
  arr[0][1] = c2 - arr[1][1];
  arr[1][0] = d2 - arr[0][1];
  for (long long i = 0; i < 2; i++) {
    for (long long j = 0; j < 2; j++) {
      if (arr[i][j] <= 0 or arr[i][j] > 9) return false;
    }
  }
  long long cnt = 0;
  if (r1 == (arr[0][0] + arr[0][1])) cnt++;
  if (r2 == (arr[1][0] + arr[1][1])) cnt++;
  if (c1 == (arr[0][0] + arr[1][0])) cnt++;
  if (c2 == (arr[0][1] + arr[1][1])) cnt++;
  if (d1 == (arr[0][0] + arr[1][1])) cnt++;
  if (d2 == (arr[1][0] + arr[0][1])) cnt++;
  if (cnt != 6) return false;
  set<long long> s;
  for (long long i = 0; i < 2; i++) {
    for (long long j = 0; j < 2; j++) {
      s.insert(arr[i][j]);
    }
  }
  if (s.size() == 4)
    return true;
  else
    return false;
}
int32_t main() {
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  bool flag = false;
  for (long long i = 1; i <= 9; i++) {
    memset(arr, 0, sizeof(arr));
    flag = check(i);
    if (flag == true) break;
  }
  if (flag) {
    for (long long i = 0; i < 2; i++) {
      for (long long j = 0; j < 2; j++) {
        cout << arr[i][j] << " ";
      }
      cout << endl;
    }
  } else
    cout << "-1" << endl;
}
