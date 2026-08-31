#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  int n;
  cin >> n;
  int h[n], a[n];
  for (int i = 0; i < n; i++) {
    cin >> h[i] >> a[i];
  }
  int cnt = 0;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (h[i] == a[j]) cnt++;
    }
  }
  cout << cnt;
  return 0;
}
