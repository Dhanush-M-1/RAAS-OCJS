#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<int> v1(n), v2(n - 1), v3(n - 2);
  for (int i = 0; i < n; ++i) cin >> v1[i];
  for (int i = 0; i < n - 1; ++i) cin >> v2[i];
  for (int i = 0; i < n - 2; ++i) cin >> v3[i];
  sort(v1.begin(), v1.end());
  sort(v2.begin(), v2.end());
  sort(v3.begin(), v3.end());
  int x1 = 0, x2 = 0;
  for (int i = 0; i < n - 1; ++i)
    if (v1[i] != v2[i]) {
      x1 = v1[i];
      break;
    }
  if (!x1) x1 = v1[n - 1];
  for (int i = 0; i < n - 2; ++i)
    if (v3[i] != v2[i]) {
      x2 = v2[i];
      break;
    }
  if (!x2) x2 = v2[n - 2];
  cout << x1 << endl;
  cout << x2 << endl;
}
