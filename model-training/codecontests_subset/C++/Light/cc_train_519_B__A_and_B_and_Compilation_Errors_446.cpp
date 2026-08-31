#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  map<int, int> a, b;
  for (int i = 0; i < n; i++) {
    int t;
    cin >> t;
    if (a.find(t) == a.end())
      a[t] = 1;
    else
      a[t]++;
  }
  for (int i = 0; i < n - 1; i++) {
    int t;
    cin >> t;
    a[t]--;
    if (a[t] == 0) a.erase(t);
    if (b.find(t) == b.end())
      b[t] = 1;
    else
      b[t]++;
  }
  cout << a.begin()->first << endl;
  for (int i = 0; i < n - 2; i++) {
    int t;
    cin >> t;
    b[t]--;
    if (b[t] == 0) b.erase(t);
  }
  cout << b.begin()->first << endl;
  return 0;
}
