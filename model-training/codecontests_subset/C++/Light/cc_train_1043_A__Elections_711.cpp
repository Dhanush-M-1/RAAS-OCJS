#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
const double PI = acos(-1.0);
const int N = 123;
int n, a[N];
int main(void) {
  ios_base::sync_with_stdio(false);
  cin >> n;
  int k = 0;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    k = max(a[i], k);
  }
  int va = 0, vb = 0;
  for (int i = 0; i < n; i++) {
    va += a[i];
    vb += k - a[i];
  }
  while (vb <= va) {
    k++;
    vb += n;
  }
  cout << k << endl;
  return 0;
}
