#include <bits/stdc++.h>
using namespace std;
const int debug = 0;
const int inf = 1000000000;
int full[212345];
int half[212345];
int fullBox[500];
int halfBox[500];
int n, k, a, b, q;
int main() {
  cin >> n >> k >> a >> b >> q;
  for (int i = 1; i <= n; i++) full[i] = half[i] = 0;
  while (q--) {
    int t, d, amount;
    cin >> t >> d;
    if (t == 1) {
      cin >> amount;
      int newValue = half[d] + amount;
      if (newValue > b) newValue = b;
      int diff = newValue - half[d];
      int boxId = (d - 1) / 500 + 1;
      halfBox[boxId] += diff;
      half[d] = newValue;
      newValue = full[d] + amount;
      if (newValue > a) newValue = a;
      diff = newValue - full[d];
      fullBox[boxId] += diff;
      full[d] = newValue;
    } else {
      int dd = d - 1;
      int sum = 0;
      while (dd > 0) {
        if (dd % 500 == 0) {
          int boxId = (dd - 1) / 500 + 1;
          sum += halfBox[boxId];
          dd -= 500;
        } else {
          sum += half[dd];
          dd--;
        }
      }
      dd = d + k;
      while (dd <= n) {
        if ((dd - 1) % 500 == 0) {
          int boxId = (dd - 1) / 500 + 1;
          sum += fullBox[boxId];
          dd += 500;
        } else {
          sum += full[dd];
          dd++;
        }
      }
      cout << sum << endl;
    }
  }
  return 0;
}
