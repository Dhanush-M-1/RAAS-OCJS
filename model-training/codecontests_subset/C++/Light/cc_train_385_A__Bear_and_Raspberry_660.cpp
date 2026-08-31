#include <bits/stdc++.h>
using namespace std;
int arr[121];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int N, c, ans = 0;
  cin >> N >> c;
  for (int i = 1; i <= N; i++) {
    cin >> arr[i];
  }
  for (int i = 1; i < N; i++) {
    ans = max(arr[i] - c - arr[i + 1], ans);
  }
  cout << ans << endl;
}
