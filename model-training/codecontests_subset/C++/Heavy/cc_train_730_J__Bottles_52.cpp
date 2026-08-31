#include <bits/stdc++.h>
using namespace std;
int inf = 2e9;
int mod = 1e9 + 7;
char en = '\n';
int arr[105], arr2[105], temp[105];
unordered_map<int, int> par[105][105];
int recur(int i, int k, int sum) {
  if (par[i][k].count(sum)) return par[i][k][sum];
  if (k == 0) {
    if (sum <= 0)
      return 0;
    else
      return -inf;
  }
  if (i == 0) {
    return -inf;
  }
  int val =
      max(recur(i - 1, k, sum), arr[i] + recur(i - 1, k - 1, sum - arr2[i]));
  par[i][k][sum] = val;
  return val;
}
int main() {
  int n;
  cin >> n;
  int sum1 = 0;
  for (int i = 1; i <= n; i++) {
    cin >> arr[i];
    sum1 += arr[i];
  }
  for (int i = 1; i <= n; i++) {
    cin >> arr2[i];
    temp[i] = arr2[i];
  }
  int k;
  int curr = 0;
  sort(temp + 1, temp + n + 1, greater<int>());
  for (int i = 1; i <= n; i++) {
    curr += temp[i];
    if (curr >= sum1) {
      k = i;
      break;
    }
  }
  int t = recur(n, k, sum1);
  cout << k << " " << sum1 - t << en;
  return 0;
}
