#include <bits/stdc++.h>
using namespace std;
map<int, int> m1, m2;
int a[100001];
int b[100001];
int main() {
  ios_base::sync_with_stdio(false);
  int n, val;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> b[i];
    m2[b[i]]++;
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> val;
    m1[val]++;
  }
  int ans1, ans2;
  for (int i = 0; i < n - 1; i++) {
    if (m1[b[i]] == 0) {
      ans1 = b[i];
    } else
      m1[b[i]]--;
  }
  for (int i = 0; i < n; i++) {
    if (m2[a[i]] == 0) {
      ans2 = a[i];
    } else
      m2[a[i]]--;
  }
  cout << ans2 << endl << ans1 << endl;
  return 0;
}
