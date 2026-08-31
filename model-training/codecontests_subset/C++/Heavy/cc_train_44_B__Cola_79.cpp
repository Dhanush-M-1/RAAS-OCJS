#include <bits/stdc++.h>
using namespace std;
template <class T>
void show(T a, int n) {
  for (int i = 0; i < n; ++i) cout << a[i] << ' ';
  cout << endl;
}
template <class T>
void show(T a, int r, int l) {
  for (int i = 0; i < r; ++i) show(a[i], l);
  cout << endl;
}
const int N = 128 * 2;
const int M = 5000;
const int oo = 10000 * 10000 * 10;
int n, a, b, c;
int cal(int tn) {
  int lo = (n - 2 * b > 0 ? n - 2 * b : 0);
  int hi = (a < tn ? a : tn);
  if (lo > hi) return 0;
  int ans = (hi - lo + 1) / 2;
  if ((hi - lo + 1) % 2 == 0) return ans;
  if (tn % 2 == hi % 2) {
    return ans + 1;
  } else
    return ans;
}
int main() {
  int i, j, cas = 0;
  cin >> n >> a >> b >> c;
  n += n;
  long long ans = 0;
  for (; n >= 0 && c >= 0; n -= 4, c--) {
    ans += cal(n);
  }
  cout << ans << endl;
  return 0;
}
