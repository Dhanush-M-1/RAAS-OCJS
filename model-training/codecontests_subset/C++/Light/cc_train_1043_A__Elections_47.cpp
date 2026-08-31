#include <bits/stdc++.h>
using namespace std;
using ll = long long;
int main() {
  ios::sync_with_stdio(0), cin.tie(0);
  int n;
  cin >> n;
  vector<int> arr(n);
  for (int i = 0; i < n; ++i) cin >> arr[i];
  int sum = accumulate((arr).begin(), (arr).end(), 0);
  for (int i = *max_element((arr).begin(), (arr).end());; ++i)
    if (i * n - sum > sum) {
      cout << i;
      return 0;
    }
  return 0;
}
