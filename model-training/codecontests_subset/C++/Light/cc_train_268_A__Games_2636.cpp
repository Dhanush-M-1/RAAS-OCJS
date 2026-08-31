#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, ar1[40], ar2[40];
  int t = 0;
  cin >> n;
  for (int i = 0; i < n; i++) cin >> ar1[i] >> ar2[i];
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (ar1[i] == ar2[j]) t++;
    }
  }
  cout << t << endl;
}
