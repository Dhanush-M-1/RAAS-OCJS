#include <bits/stdc++.h>
using namespace std;
char in[300005];
int main() {
  int n;
  cin >> n;
  scanf("%s", in);
  int f = 0;
  for (int i = 1; i < n; i++) {
    if (in[i] < in[i - 1]) {
      f = 1;
      cout << "YES" << endl;
      cout << i << " " << i + 1 << endl;
      break;
    }
  }
  if (!f) {
    cout << "NO" << endl;
  }
  return 0;
}
