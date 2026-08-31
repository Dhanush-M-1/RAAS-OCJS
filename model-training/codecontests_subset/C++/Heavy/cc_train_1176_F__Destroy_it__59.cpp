#include <bits/stdc++.h>
using namespace std;
using ll = long long;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  int T;
  cin >> T;
  vector<ll> B(10, -1);
  B[0] = 0;
  while (T--) {
    int N;
    cin >> N;
    ll a1 = 0, a2 = 0, a3 = 0, a4 = 0, b = 0, c = 0;
    for (int i = 0; i < N; i++) {
      ll x, y;
      cin >> x >> y;
      if (x == 1) {
        a4 = y;
        if (a3 < a4) swap(a3, a4);
        if (a2 < a3) swap(a2, a3);
        if (a1 < a2) swap(a1, a2);
      } else if (x == 2)
        b = max(b, y);
      else
        c = max(c, y);
    }
    ll x1 = max({a1, b, c}), y1 = x1;
    ll x3 = (a3 > 0) * (a1 + a2 + a3), y3 = a1;
    ll x2 = 0, y2 = 0;
    if (a2) x2 = a1 + a2, y2 = a1;
    if (a1 && a2 < b) x2 = a1 + b, y2 = max(a1, b);
    vector<ll> C = B;
    for (int i = 0; i < 10; i++)
      if (B[i] >= 0) {
        C[(i + 1) % 10] =
            max(C[(i + 1) % 10], B[i] + (x1) + (i + 1 >= 10) * (y1));
        if (x2)
          C[(i + 2) % 10] =
              max(C[(i + 2) % 10], B[i] + (x2) + (i + 2 >= 10) * (y2));
        if (x3)
          C[(i + 3) % 10] =
              max(C[(i + 3) % 10], B[i] + (x3) + (i + 3 >= 10) * (y3));
      }
    B = C;
  }
  cout << *max_element(begin(B), end(B));
}
