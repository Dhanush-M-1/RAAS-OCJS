#include <bits/stdc++.h>
bool myfunc(int a, int b) { return (a > b); }
using namespace std;
int main(void) {
  int l, n, k;
  vector<int> a;
  cin >> n >> k;
  for (int i = 0; i < n; i++) {
    cin >> l;
    a.push_back(l);
  }
  sort(a.begin(), a.end(), myfunc);
  for (int i = 0; i < n; i++) {
    if (k % a[i] == 0) {
      cout << k / a[i] << endl;
      break;
    }
  }
  return 0;
}
