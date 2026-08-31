#include <bits/stdc++.h>
using namespace std;
void test() {
  int n, j;
  cin >> n >> j;
  map<int, int> m;
  map<int, int> m2;
  vector<int> a(n), b(j);
  int in;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    m[a[i]]++;
  }
  for (int i = 0; i < j; i++) {
    cin >> b[i];
  }
  int flag = 0;
  for (int i = 0; i < j; i++) {
    if (m[b[i]] > 0) {
      cout << "YES\n1 " << b[i] << "\n";
      flag = 1;
      break;
    }
  }
  if (flag == 0) {
    cout << "NO"
         << "\n";
  }
}
int main() {
  int t;
  cin >> t;
  while (t--) {
    test();
  }
}
