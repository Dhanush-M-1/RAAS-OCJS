#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  int n;
  cin >> n;
  string m[n];
  int i, j, k;
  for (i = 0; i < n; i++) {
    cin >> m[i];
  }
  string tp = "";
  string save = "";
  int key = 0;
  for (i = 0; i < n; i++) {
    tp = tp + m[i];
    save = tp;
    for (j = 0; j < n; j++) {
      tp = save;
      tp = tp + m[j];
      for (k = 0; k < tp.size() - 1; k++) {
        if (tp[k] == s[0] && tp[k + 1] == s[1]) {
          key = 1;
        }
      }
    }
  }
  if (key == 1)
    cout << "YES";
  else
    cout << "NO";
}
