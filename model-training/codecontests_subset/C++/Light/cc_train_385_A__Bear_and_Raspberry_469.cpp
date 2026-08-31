#include <bits/stdc++.h>
using namespace std;
const int maxn = 110;
int price[maxn];
int main() {
  int n, c;
  cin >> n >> c;
  for (int i = 0; i < n; i++) {
    cin >> price[i];
  }
  int maxRa = 0;
  for (int i = 0; i < n - 1; i++) {
    maxRa = max(maxRa, price[i] - price[i + 1]);
  }
  cout << max(0, maxRa - c) << endl;
  return 0;
}
