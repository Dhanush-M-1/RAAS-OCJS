#include <bits/stdc++.h>
using namespace std;
long long arr[100001], sum[100001], mx[100001];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int n, d;
  cin >> n >> d;
  for (auto i = 0; i < (long long)(n); i++) {
    cin >> arr[i];
    sum[i] = arr[i];
    if (i) sum[i] += sum[i - 1];
  }
  mx[n - 1] = sum[n - 1];
  for (int i = n - 2; i >= 0; i--) mx[i] = max(mx[i + 1], sum[i]);
  long long curr = 0, ret = 0;
  for (auto i = 0; i < (long long)(n); i++) {
    if (sum[i] + curr > d) return cout << -1, 0;
    if (!arr[i] && sum[i] + curr < 0) {
      long long extra = d - (mx[i] + curr);
      if (sum[i] + curr + extra < 0) return cout << -1, 0;
      ret++;
      curr += extra;
    }
  }
  cout << ret << '\n';
  return 0;
}
