#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  string first, second;
  cin >> first >> second;
  int n;
  cin >> n;
  cout << first << " " << second << endl;
  for (int i = 0; i < n; i++) {
    string killed, replaceWith;
    cin >> killed >> replaceWith;
    if (killed == first) {
      first = replaceWith;
    } else {
      second = replaceWith;
    }
    cout << first << " " << second << endl;
  }
}
