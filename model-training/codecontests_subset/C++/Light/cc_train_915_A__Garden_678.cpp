#include <bits/stdc++.h>
using namespace std;
bool comp(int a, int b) { return a > b; }
int main() {
  ios_base ::sync_with_stdio(0);
  cin.tie(0);
  int n, k;
  cin >> n >> k;
  int a[n + 1];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  sort(a, a + n);
  reverse(a, a + n);
  for (int i = 0; i < n; i++) {
    if (k % a[i] == 0) {
      cout << k / a[i] << endl;
      return 0;
    }
  }
  return 0;
}
