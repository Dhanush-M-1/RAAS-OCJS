#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  long long tot1 = 0, tot2 = 0, tot3 = 0;
  int temp = 0;
  for (int i = 0; i < n; i++) {
    cin >> temp;
    tot1 += temp;
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> temp;
    tot2 += temp;
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> temp;
    tot3 += temp;
  }
  cout << tot1 - tot2 << endl;
  cout << tot2 - tot3;
  return 0;
}
