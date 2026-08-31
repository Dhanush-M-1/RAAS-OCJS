#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using ld = long double;
using pii = pair<int, int>;
int n;
int main() {
  ios::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  cin >> n;
  for (int i = 1; i < n; i++) {
    for (int j = 1; j < n; j++) cout << (i * j / n) * 10 + (i * j % n) << ' ';
    cout << '\n';
  }
}
