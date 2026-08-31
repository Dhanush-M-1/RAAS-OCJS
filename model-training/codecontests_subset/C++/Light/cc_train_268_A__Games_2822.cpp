#include <bits/stdc++.h>
using namespace std;
int arr[30][2], n, cnt = 0;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> arr[i][1] >> arr[i][2];
  for (int i = 1; i <= n - 1; i++) {
    for (int j = i + 1; j <= n; j++) {
      if (arr[i][1] == arr[j][2]) cnt++;
      if (arr[i][2] == arr[j][1]) cnt++;
    }
  }
  cout << cnt;
}
