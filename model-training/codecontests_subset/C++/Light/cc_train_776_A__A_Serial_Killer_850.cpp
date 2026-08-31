#include <bits/stdc++.h>
using namespace std;
long long int arr[100005];
string s, s1, s2, s3;
int main() {
  long long int i, j, k, l, z, step = 0, n, m, ass, t, w, r, x, y, c = 0, f = 0;
  cin >> s >> s1;
  cin >> n;
  cout << s << " " << s1 << endl;
  for (i = 0; i < n; i++) {
    cin >> s2 >> s3;
    if (s2 == s) {
      cout << s1 << " " << s3 << endl;
      s = s3;
    } else {
      cout << s << " " << s3 << endl;
      s1 = s3;
    }
  }
}
