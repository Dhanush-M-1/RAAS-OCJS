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
int main() {
  amhu();
  int a, tp = 0, tp2 = 0, tp3 = 0, x, y, z;
  cin >> a;
  for (int i = 0; i < a; i++) {
    cin >> x;
    tp += x;
  }
  int b = a - 1;
  for (int i = 0; i < b; i++) {
    cin >> y;
    tp2 += y;
  }
  int c = b - 1;
  for (int i = 0; i < c; i++) {
    cin >> z;
    tp3 += z;
  }
  cout << abs(tp - tp2) << "\n" << abs(tp2 - tp3) << endl;
}
