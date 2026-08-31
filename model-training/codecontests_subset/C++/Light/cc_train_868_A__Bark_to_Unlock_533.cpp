#include <bits/stdc++.h>
using namespace std;
int main() {
  string pw, kash[100];
  int n;
  cin >> pw >> n;
  bool ans = false;
  for (int i = 0; i < n; i++) {
    cin >> kash[i];
    if (kash[i][0] == pw[0] && kash[i][1] == pw[1]) ans = true;
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (kash[i][1] == pw[0] && kash[j][0] == pw[1]) ans = true;
    }
  }
  if (ans)
    cout << "Yes" << endl;
  else
    cout << "No" << endl;
  return 0;
}
