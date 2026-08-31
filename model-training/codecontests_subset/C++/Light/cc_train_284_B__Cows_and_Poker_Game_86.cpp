#include <bits/stdc++.h>
using namespace std;
int main() {
  int N;
  cin >> N;
  string s;
  cin >> s;
  int contA = 0, contI = 0, contF = 0;
  for (int i = 0; i < N; i++) {
    if (s[i] == 'A') contA++;
    if (s[i] == 'I') contI++;
    if (s[i] == 'F') contF++;
  }
  if (contI <= 1) {
    if (contI == 1)
      cout << 1 << endl;
    else
      cout << contA << endl;
  } else {
    cout << 0 << endl;
  }
  return 0;
}
