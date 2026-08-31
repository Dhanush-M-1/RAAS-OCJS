#include <bits/stdc++.h>
using namespace std;
long long int fen[200005];
void upd(long long int x, long long int a) {
  for (long long int i = x; i < 200005; i += (i & (-i))) {
    fen[i] += a;
  }
}
long long int ret(long long int x) {
  long long int o = 0;
  for (long long int i = x; i > 0; i -= (i & (-i))) {
    o += fen[i];
  }
  return o;
}
int main() {
  long long int n;
  cin >> n;
  long long int s[n];
  for (long long int i = 0; i < n; i++) {
    cin >> s[i];
    upd(i + 1, i + 1);
  }
  long long int out[n];
  for (long long int i = n - 1; i >= 0; i--) {
    long long int l = 0, h = n - 1;
    while (h - l > 1) {
      long long int mi = (h + l) / 2;
      if (ret(mi) > s[i]) {
        h = mi;
      } else {
        l = mi;
      }
    }
    if (ret(h) == s[i]) {
      out[i] = h + 1;
      upd(h + 1, -h - 1);
    } else {
      out[i] = l + 1;
      upd(l + 1, -l - 1);
    }
    cout << "\n";
  }
  for (long long int i = 0; i < n; i++) {
    cout << out[i] << " ";
  }
  return 0;
}
