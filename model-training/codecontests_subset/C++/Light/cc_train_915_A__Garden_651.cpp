#include <bits/stdc++.h>
using namespace std;
int n, k, a, mit;
int main() {
  cin >> n >> k;
  mit = 10000000;
  for (int i = 0; i < n; i++) {
    cin >> a;
    if (k % a == 0) mit = min(mit, k / a);
  }
  cout << mit << "\n";
}
