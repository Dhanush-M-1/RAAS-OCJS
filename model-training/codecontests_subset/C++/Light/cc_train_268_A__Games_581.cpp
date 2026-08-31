#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int a[n][2], k = 0;
  for (int i = 0; i < n; i++) {
    cin >> a[i][0] >> a[i][1];
  }
  for (int i = 0; i < n; i++) {
    for (int l = 0; l < n; l++) {
      if (i != l)
        if (a[i][0] == a[l][1]) k++;
    }
  }
  cout << k;
}
