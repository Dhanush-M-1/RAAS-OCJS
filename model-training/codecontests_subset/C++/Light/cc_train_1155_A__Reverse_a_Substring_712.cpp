#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  int maxi = -1, maxiidx;
  for (int i = 0; i < n; i++) {
    if (s[i] - 'a' < maxi && maxi != -1) {
      cout << "YES" << endl;
      cout << maxiidx << " " << i + 1;
      return 0;
    }
    if (s[i] - 'a' > maxi) {
      maxiidx = i + 1;
      maxi = s[i] - 'a';
    }
  }
  cout << "NO";
  return 0;
  return 0;
}
