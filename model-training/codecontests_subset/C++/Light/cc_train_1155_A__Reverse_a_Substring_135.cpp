#include <bits/stdc++.h>
using namespace std;
vector<int> a, b, c, e;
int main() {
  long long int n, a;
  bool flag = false;
  string s;
  cin >> n >> s;
  for (int i = 0; i < n - 1; i++) {
    if (s[i + 1] < s[i]) {
      cout << "YES" << endl;
      cout << i + 1 << " " << i + 2;
      flag = true;
      break;
    }
  }
  if (!flag) cout << "NO" << endl;
}
