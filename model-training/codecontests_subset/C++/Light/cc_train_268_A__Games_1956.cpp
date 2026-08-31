#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, h[101] = {0}, w[101], hh, game = 0;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> hh >> w[i];
    h[hh]++;
  }
  for (int i = 0; i < n; i++) game += h[w[i]];
  cout << game << endl;
  return 0;
}
