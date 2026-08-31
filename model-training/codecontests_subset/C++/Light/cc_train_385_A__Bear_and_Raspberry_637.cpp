#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c, i;
  int x[102];
  cin >> n >> c;
  for (i = 0; i < n; i++) cin >> x[i];
  vector<int> l;
  for (i = 0; i < n - 1; i++) {
    int temp = x[i] - x[i + 1] - c;
    if (temp <= 0)
      l.push_back(0);
    else
      l.push_back(temp);
  }
  sort(l.begin(), l.end());
  cout << l.back() << endl;
  return 0;
}
