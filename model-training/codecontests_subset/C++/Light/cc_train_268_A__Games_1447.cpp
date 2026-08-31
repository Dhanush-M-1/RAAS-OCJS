#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c = 0, freq[101] = {0};
  cin >> n;
  int x[n], y[n];
  for (int i = 0; i < n; i++) {
    cin >> x[i] >> y[i];
    freq[x[i]]++;
  }
  for (int i = 0; i < n; i++) {
    c += freq[y[i]];
  }
  cout << c;
  return 0;
}
