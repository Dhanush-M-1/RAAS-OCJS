#include <bits/stdc++.h>
using namespace std;
long long a[300001];
long long b[300000];
long long c[29999];
bool used[600001];
int main() {
  ios_base::sync_with_stdio(0);
  int n, suma = 0, sumb = 0, sumc = 0;
  cin >> n;
  for (int i = 0; i < n; ++i) {
    cin >> a[i];
    suma += a[i];
  }
  for (int i = 0; i < n - 1; ++i) {
    cin >> b[i];
    sumb += b[i];
  }
  for (int i = 0; i < n - 2; ++i) {
    cin >> c[i];
    sumc += c[i];
  }
  cout << suma - sumb << "\n" << sumb - sumc;
}
