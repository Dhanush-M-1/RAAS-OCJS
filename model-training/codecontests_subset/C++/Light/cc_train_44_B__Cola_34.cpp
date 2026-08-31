#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b, c, cnt = 0;
  cin >> n >> a >> b >> c;
  for (int i = 0; i <= a; ++i) {
    for (int j = 0; j <= b; ++j) {
      if (i % 2) continue;
      int aldik = i / 2 + j;
      int kaldi = n - aldik;
      if (aldik > n) continue;
      if (kaldi % 2 == 0 && kaldi / 2 <= c) cnt++;
    }
  }
  cout << cnt;
}
