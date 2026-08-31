#include <bits/stdc++.h>
using namespace std;
int n, a[100001], b[100001], c[100001], x;
map<int, int> a1, b1, c1;
int main() {
  srand(time(NULL));
  cin >> n;
  for (int i = 1; i <= n; ++i) cin >> a[i], a1[a[i]]++;
  for (int i = 1; i < n; ++i) cin >> b[i], b1[b[i]]++, a1[b[i]]--;
  for (int i = 1; i < n - 1; ++i) cin >> c[i], b1[c[i]]--;
  for (int i = 1; i <= n; ++i)
    if (a1[a[i]] != 0) cout << a[i] << endl, a1[a[i]]--;
  for (int i = 1; i < n; ++i)
    if (b1[b[i]] != 0) cout << b[i], b1[b[i]]--;
}
