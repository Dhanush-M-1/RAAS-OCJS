#include <bits/stdc++.h>
using namespace std;
const int MXN = 1e5 + 20;
int n, a[MXN], b[MXN], c[MXN];
vector<int> ans;
void IN() {
  int tmp;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> tmp;
    a[i] = tmp;
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> tmp;
    b[i] = tmp;
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> tmp;
    c[i] = tmp;
  }
}
void SLV() {
  sort(a, a + n);
  sort(b, b + n - 1);
  sort(c, c + n - 2);
  for (int i = 0; i < n; i++)
    if (b[i] != a[i]) {
      ans.push_back(a[i]);
      break;
    }
  for (int i = 0; i < n; i++)
    if (c[i] != b[i]) {
      ans.push_back(b[i]);
      break;
    }
}
void OUT() {
  for (auto i : ans) cout << i << endl;
}
int main() {
  IN();
  SLV();
  OUT();
  return 0;
}
