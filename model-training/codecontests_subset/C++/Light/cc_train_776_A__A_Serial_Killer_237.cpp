#include <bits/stdc++.h>
using namespace std;
int main() {
  setlocale(LC_CTYPE, "rus");
  string s1, s2, s3, s4, s5[1002][2];
  long int N, i, j;
  cin >> s1 >> s2;
  cin >> N;
  s5[0][0] = s1;
  s5[0][1] = s2;
  for (i = 0; i < N; i++) {
    cin >> s3 >> s4;
    if (s3 == s1)
      s1 = s4;
    else if (s3 == s2)
      s2 = s4;
    s5[i + 1][0] = s1;
    s5[i + 1][1] = s2;
  }
  for (i = 0; i < N + 1; i++) {
    cout << s5[i][0] << ' ' << s5[i][1];
    if (i != N) cout << endl;
  }
}
