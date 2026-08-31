#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int k;
  cin >> k;
  int out = k;
  for (int i = 0; i < n; i++) {
    int ai;
    cin >> ai;
    if (k % ai == 0 and k / ai < out) {
      out = k / ai;
    }
  }
  cout << out << endl;
}
