#include <bits/stdc++.h>
using namespace std;
int main(int argc, char **argv) {
  int n, r = 0;
  cin >> n;
  int h[n], v[n];
  for (int k = 0; k < n; k++) {
    cin >> h[k] >> v[k];
  }
  for (int k = 0; k < n; k++) {
    for (int j = 0; j < n; j++) {
      if (h[k] == v[j] && k != j) r++;
    }
  }
  cout << r << endl;
  return 0;
}
