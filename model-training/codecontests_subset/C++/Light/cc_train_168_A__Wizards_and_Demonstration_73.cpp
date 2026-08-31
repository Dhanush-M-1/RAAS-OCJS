#include <bits/stdc++.h>
using namespace std;
double N, W, Y;
int main() {
  double need;
  int k = 0;
  cin >> N >> W >> Y;
  need = N * (Y / 100);
  if (need <= W)
    cout << 0;
  else {
    if (need != (int)need) k = 1;
    cout << (int)need - W + k;
  }
  return 0;
}
