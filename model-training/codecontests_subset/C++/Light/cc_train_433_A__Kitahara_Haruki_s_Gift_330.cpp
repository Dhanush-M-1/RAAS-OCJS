#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, t;
  cin >> n;
  map<int, int> co;
  while (n--) {
    cin >> t;
    co[t]++;
  }
  bool flag = true;
  if (co[100] % 2 == 1 || (co[200] % 2 == 1 && co[100] == 0)) {
    cout << "NO";
  } else
    cout << "YES";
  return 0;
}
