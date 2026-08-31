#include <bits/stdc++.h>
using namespace std;
bool mycompare(pair<int, int> p1, pair<int, int> p2) {
  return p1.first < p2.first;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  int n;
  cin >> n;
  int a[n], n1 = 0, n2 = 0;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    if (a[i] == 100)
      n1 += 1;
    else
      n2 += 1;
  }
  if ((n1 % 2 == 0 && n1 != 0) || (n1 == 0 && n2 % 2 == 0))
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
  return 0;
}
