#include <bits/stdc++.h>
using namespace std;
int a[100009], b[100009];
int n, m, an1, an2;
map<int, int> x, y;
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    x[a[i]]++;
  }
  for (int i = 1; i < n; i++) {
    cin >> b[i];
    y[b[i]]++;
    x[b[i]]--;
  }
  for (int i = 2; i < n; i++) {
    int c;
    cin >> c;
    y[c]--;
  }
  for (int i = 0; i < n; i++) {
    if (x[a[i]] > 0) {
      an1 = a[i];
      break;
    }
  }
  for (int i = 1; i < n; i++) {
    if (y[b[i]] > 0) {
      an2 = b[i];
      break;
    }
  }
  cout << an1 << endl << an2 << endl;
}
