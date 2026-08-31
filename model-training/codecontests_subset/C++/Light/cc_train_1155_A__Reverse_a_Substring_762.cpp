#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  long long int n;
  cin >> n;
  string second;
  cin >> second;
  long long int l = -1, r = -1;
  for (long long int i = 0; i < n - 1; i++) {
    if (second[i] > second[i + 1]) {
      l = i, r = i + 1;
      break;
    }
  }
  if (l == -1) {
    cout << "NO";
  } else {
    cout << "YES"
         << "\n";
    cout << l + 1 << " " << r + 1;
  }
  return 0;
}
