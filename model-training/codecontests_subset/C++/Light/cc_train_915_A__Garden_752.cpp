#include <bits/stdc++.h>
using namespace std;
int main(int argc, const char* argv[]) {
  int n, k;
  cin >> n >> k;
  int max = -1;
  int x;
  for (int i = 0; i < n; i++) {
    cin >> x;
    if ((k % x == 0) && (x > max)) max = x;
  }
  cout << (k / max) << endl;
  return 0;
}
