#include <bits/stdc++.h>
using namespace std;
string s1, s2, t1, t2;
int n;
int main() {
  cin.tie(NULL);
  cout.tie(NULL);
  ios_base::sync_with_stdio(false);
  cin >> s1 >> s2;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cout << s1 << " " << s2 << "\n";
    cin >> t1 >> t2;
    if (s1 == t1)
      s1 = t2;
    else
      s2 = t2;
  }
  cout << s1 << " " << s2;
}
