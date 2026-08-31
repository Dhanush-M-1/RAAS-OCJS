#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b;
  cin >> n;
  vector<int> v;
  for (int i = 0; i < n; i++) {
    cin >> a;
    v.push_back(a);
  }
  sort(v.begin(), v.end());
  b = v[n - 1];
  int s = 0;
  for (int i = 0; i < n; i++) s = s + v[i];
  if (((s * 2) + 1) % n == 0)
    cout << max(b, ((s * 2) + 1) / n);
  else
    cout << max(b, (((s * 2) + 1) / n) + 1);
}
