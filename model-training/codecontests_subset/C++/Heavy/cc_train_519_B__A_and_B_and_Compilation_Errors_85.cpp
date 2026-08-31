#include <bits/stdc++.h>
using namespace std;
int pr(long long x) {
  for (long long i = 2; i * i <= x; i++) {
    if (x % i == 0) return 0;
  }
  return 1;
}
void amhu() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
}
int arr[10000001];
int x[1000001], y[1000001], z[1000001];
int main() {
  amhu();
  int a, tp = 0, tp2 = 0;
  cin >> a;
  for (int i = 0; i < a; i++) cin >> x[i];
  sort(x, x + a);
  int b = a - 1;
  for (int i = 0; i < b; i++) cin >> y[i];
  sort(y, y + b);
  int c = b - 1;
  for (int i = 0; i < c; i++) cin >> z[i];
  sort(z, z + c);
  for (int i = 0; i < a; i++) {
    if (x[i] != y[i]) {
      tp = x[i];
      break;
    }
  }
  if (tp != 0)
    cout << tp << endl;
  else
    cout << x[a - 1] << endl;
  for (int i = 0; i < b; i++) {
    if (y[i] != z[i]) {
      tp2 = y[i];
      break;
    }
  }
  if (tp2 != 0)
    cout << tp2 << endl;
  else
    cout << y[b - 1] << endl;
}
