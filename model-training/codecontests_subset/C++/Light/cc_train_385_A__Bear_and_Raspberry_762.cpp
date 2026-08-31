#include <bits/stdc++.h>
using namespace std;
int MAXSHORT = 0x7fff;
int main() {
  int n, c;
  cin >> n >> c;
  int best = 0, k, last = -1;
  for (int i = 0; i < (int)(n); ++i) {
    cin >> k;
    best = max(last - k - c, best);
    last = k;
  }
  cout << best << endl;
}
