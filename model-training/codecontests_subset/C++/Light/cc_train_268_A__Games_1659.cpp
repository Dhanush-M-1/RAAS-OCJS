#include <bits/stdc++.h>
using namespace std;
int main() {
  int x[101], y[101];
  int n, a = 0;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> x[i] >> y[i];
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < i; j++) {
      if (x[i] == y[j]) a++;
      if (x[j] == y[i]) a++;
    }
  }
  cout << a << endl;
}
