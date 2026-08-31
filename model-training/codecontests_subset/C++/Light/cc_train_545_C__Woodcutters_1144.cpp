#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  pair<int, int> arr[n];
  for (int i = 0; i < n; i++) cin >> arr[i].first >> arr[i].second;
  if (n <= 2)
    cout << n << endl;
  else {
    int cnt = 2;
    int prev = arr[0].first;
    for (int i = 1; i < n - 1; i++) {
      if (arr[i].first - arr[i].second > prev) {
        cnt++;
        prev = arr[i].first;
      } else if (arr[i].first + arr[i].second < arr[i + 1].first) {
        cnt++;
        prev = arr[i].first + arr[i].second;
      } else
        prev = arr[i].first;
    }
    cout << cnt << endl;
  }
}
