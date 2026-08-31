#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  cin >> n;
  string s;
  cin >> s;
  int a[26];
  fill(a, a + 26, -1);
  for (int i = 0; i < n; i++) {
    a[s[i] - 'a'] = i + 1;
  }
  int l = -1, r = -1;
  for (int i = 0; i < n; i++) {
    int j_upto = s[i] - 'a';
    for (int j = 0; j < j_upto; j++) {
      if (a[j] != -1 && a[j] > i + 1) {
        l = i + 1, r = a[j];
      }
    }
  }
  if (l != -1) {
    cout << "YES\n" << l << " " << r << '\n';
  } else
    cout << "NO\n";
}
