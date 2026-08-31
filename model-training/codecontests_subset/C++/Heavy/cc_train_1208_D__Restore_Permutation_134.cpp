#include <bits/stdc++.h>
using namespace std;
vector<long long> bit(200001);
void update(long long x, long long y, long long n) {
  for (long long i = x; i <= n; i = i + (i & (-i))) bit[i] += y;
}
int search(long long x, int n) {
  long long ans = 0, sum = 0;
  for (int i = 21; i >= 0; i--) {
    if (ans + (1LL << i) <= n && sum + bit[ans + (1LL << i)] <= x) {
      ans = ans + (1LL << i);
      sum = sum + bit[ans];
    }
  }
  return ans + 1;
}
int main() {
  int n;
  cin >> n;
  vector<long long> arr(n + 1);
  for (int i = 1; i <= n; i++) {
    cin >> arr[i];
    update(i, i, n);
  }
  vector<int> ans(n + 1);
  for (int i = n; i > 0; i--) {
    ans[i] = search(arr[i], n);
    update(ans[i], -ans[i], n);
  }
  for (int i = 1; i <= n; i++) cout << ans[i] << " ";
}
