#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 7;
const long long INF = 1e9 + 7;
const long double EPS = 1e-9;
const long long P = 485437;
const int C = 2016;
int a[N], b[N], c[N];
void read(int n, int* a) {
  for (int i = 0; i < n; i++) cin >> a[i];
  sort(a, a + n);
}
int cmp(int* a, int* b, int n) {
  for (int i = 0; i < n - 1; i++)
    if (a[i] != b[i]) return a[i];
  return a[n - 1];
}
int main() {
  ios_base::sync_with_stdio(0);
  int n;
  cin >> n;
  read(n, a);
  read(n - 1, b);
  read(n - 2, c);
  cout << cmp(a, b, n) << endl << cmp(b, c, n - 1) << endl;
  return 0;
}
