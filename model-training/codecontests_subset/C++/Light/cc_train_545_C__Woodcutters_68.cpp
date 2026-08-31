#include <bits/stdc++.h>
using namespace std;
const int N = 100005;
int x[N], h[N];
void jebaj() {
  int n;
  cin >> n;
  for (auto i = (0); i <= ((n)-1); ++i) {
    cin >> x[i] >> h[i];
  }
  if (n == 1) {
    cout << "1\n";
    return;
  }
  int res = 2;
  for (auto i = (1); i <= (n - 2); ++i) {
    if (x[i] - h[i] > x[i - 1]) {
      res++;
    } else {
      if (x[i] + h[i] < x[i + 1]) {
        res++;
        x[i] += h[i];
      }
    }
  }
  cout << res << "\n";
}
int main() {
  ios_base::sync_with_stdio(0);
  int t = 1;
  for (auto i = (0); i <= ((t)-1); ++i) {
    jebaj();
  }
}
