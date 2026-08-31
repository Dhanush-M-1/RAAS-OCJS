#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, j, x, y, a1[100010], a2[100010], a3[100010], a4[100010];
  cin >> n;
  vector<int> v;
  for (i = 0; i < n; i++) cin >> a1[i];
  for (i = 0; i < n; i++) a4[i] = a1[i];
  sort(a1, a1 + n);
  for (i = 0; i < n - 1; i++) cin >> a2[i];
  sort(a2, a2 + n - 1);
  for (i = 0; i < n - 2; i++) cin >> a3[i];
  sort(a3, a3 + n - 2);
  for (i = 0, j = 0; i < n; i++) {
    if (a1[i] == a2[j])
      j++;
    else
      v.push_back(a1[i]);
  }
  for (i = 0, j = 0; i < n - 1; i++) {
    if (a2[i] == a3[j])
      j++;
    else
      v.push_back(a2[i]);
  }
  for (i = 0; i < v.size(); i++) cout << v[i] << endl;
}
