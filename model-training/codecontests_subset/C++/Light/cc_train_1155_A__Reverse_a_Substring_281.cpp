#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long int n;
  cin >> n;
  string s;
  cin >> s;
  long long int temp = 0;
  for (long long int i = 0; i < n - 1; i++) {
    if (s[i] > s[i + 1]) {
      cout << "YES" << endl << i + 1 << " " << i + 2 << endl;
      temp = 1;
      break;
    }
  }
  if (temp == 0) cout << "NO" << endl;
  return 0;
}
