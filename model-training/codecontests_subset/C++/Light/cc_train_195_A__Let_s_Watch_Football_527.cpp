#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base ::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int a, b, c, k;
  cin >> a >> b >> c;
  k = (a * c) / b;
  if ((a * c) % b) k++;
  cout << k - c;
}
