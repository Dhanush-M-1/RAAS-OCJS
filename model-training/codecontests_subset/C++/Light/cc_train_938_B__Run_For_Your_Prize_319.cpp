#include <bits/stdc++.h>
using namespace std;
vector<int> a, b;
int n;
int tmp, max_elem, ans;
bool flag = true;
int ind = 0;
int main() {
  max_elem = 0;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> tmp;
    a.push_back(tmp);
  }
  for (int i = 0; i <= n - 1; i++) {
    if (a[i] <= 500000) {
      tmp = a[i] - 1;
    } else {
      tmp = 1000000 - a[i];
    }
    if (tmp > max_elem) {
      max_elem = tmp;
    }
  }
  cout << max_elem;
  return 0;
}
